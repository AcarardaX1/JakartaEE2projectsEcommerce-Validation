/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.shoppee.business.shopping.boundary;

import com.javacourse.shoppee.business.shopping.entity.Cart;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 *
 * @author ardaacx
 */


@Stateless
public class CartService {
    
    @PersistenceContext
    EntityManager em;

    
    public Cart create(){
        return new Cart();
    }
    
    
    public Cart find(@NotNull Long id){
        return em.find(Cart.class, id);
    
    }
    
    
    public void save(@NotNull Cart cart) {
    
        if (cart.getId() == null)
            em.persist(cart);
        else
            em.merge(cart);
    }
    
      public void delete(@NotNull Long id){
    
        Cart cart = em.find(Cart.class , id); 
        
        if(cart != null){
            em.remove(cart);
        }
      
      }    
      
      
      public List<Cart> list(){
    
          return em.createQuery("SELECT c FROM Cart c", Cart.class).getResultList();
      
      
      }
      
      
}

    

        
