/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.letpartybegin.boundary;

import com.javacourse.letpartybegin.entity.Attendee;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author ardaacx
 */
@Stateless
public class AttendeeService {
    
   @PersistenceContext
   EntityManager em;
   
   private final String LIST_OF_ATTENDEES_QUERY = "SELECT a FROM Attendee a";
   
   public Attendee create() {return new Attendee(); }
    
   public Attendee find(Long id) {return em.find(Attendee.class, id);}
   
   public void save(Attendee attendee){
   
        if(attendee.getId() == null)
            em.persist(attendee);
        
        else
            em.merge(attendee);
   
   }
   
   
   public void delete(@NotNull Long id){
       
        Attendee attendee = em.find(Attendee.class, id);
        if(attendee != null){
            em.remove(attendee);
        }     
   }
   
   public EntityManager getEm() {return em;}
    
}
