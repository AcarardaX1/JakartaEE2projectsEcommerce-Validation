/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.letpartybegin.boundary;

import com.javacourse.letpartybegin.entity.Party;
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
public class PartyService {
    
    @PersistenceContext
    EntityManager em;
    
    
    public Party create() {return new Party();}
    
    public Party find(@NotNull Long id){
    
        return em.find(Party.class, id);
    
    }
    
    
    public void save(@NotNull Party party) {
    
    if(party.getId() == null)
        em.persist(party);
    else
        em.merge(party);  
    }
    
    public void delete(@NotNull Long id){
        
        Party party = em.find(Party.class, id);
        
        if(party != null){
        
            em.remove(party);
            
        }
    
    
    }
      
    
    public List<Party> list(){
    
        return em.createQuery("SELECT P FROM Party p", Party.class).getResultList();           
    
    }
    
}
