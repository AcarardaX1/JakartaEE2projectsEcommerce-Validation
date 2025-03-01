/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.shoppee.business.shopping.boundary;

import com.javacourse.shoppee.business.shopping.control.DuplicatedException;
import com.javacourse.shoppee.business.shopping.entity.Item;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author ardaacx
 */
@Stateless
public class ItemService {

    @PersistenceContext
    EntityManager em;

    private final String LIST_OF_ITEMS_QUERY = "SELECT i FROM Item i";

    public Item create() {
        return new Item();
    }

    public Item find(Long id) {

        return em.find(Item.class, id);
    }

    public void save(Item item) throws DuplicatedException{
        
        if(isNamePresent(item.getId(), item.getName()))
            throw new DuplicatedException();
            
        if (item.getId() == null)
            em.persist(item);
        else 
            em.merge(item);
        
    }

    private boolean isNamePresent(Long id , @NotBlank String name) {

        try {

            StringBuilder queryText = new StringBuilder("SELECT i.name ").append("FROM Item i ").append("WHERE i.name LIKE :name ");
            
            
           
            if(id!=null)
                queryText= queryText.append("AND NOT i.id = :id");
            
            TypedQuery<String> query = em.createQuery(queryText.toString(), String.class).setParameter("name", name);
            
            if(id!=null)
                query.setParameter("id", id);
            
            String singleResult = query.getSingleResult();

            return singleResult != null && !singleResult.isBlank();

        } catch (NoResultException e) {

            return false;
        } catch (NonUniqueResultException e) {
            return true;
        }
    }

    public void delete(@NotNull Long id) {

        Item item = em.find(Item.class, id);
        if (item != null) {
            em.remove(item);
        }
    }

    public List<Item> list() {

        return em.createQuery(LIST_OF_ITEMS_QUERY, Item.class).getResultList();

 
    
    }

    public EntityManager getEm() {
        return em;
    }
    
    
    
}
