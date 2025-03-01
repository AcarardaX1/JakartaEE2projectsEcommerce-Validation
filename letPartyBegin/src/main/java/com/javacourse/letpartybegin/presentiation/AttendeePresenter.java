/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.letpartybegin.presentiation;

import com.javacourse.letpartybegin.boundary.AttendeeService;
import com.javacourse.letpartybegin.entity.Attendee;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author ardaacx
 */

 @Named
 @ViewScoped
public class AttendeePresenter implements Serializable {

     @Inject
     private AttendeeService attendeeService;
     
     
     private Attendee attendee;
     
     private Long id;
     
     public void detail(){
     
        if(id!=null)
            attendee = attendeeService.find(id);
        
        else
            attendee = attendeeService.create();
        
     }
     
     
     public String save(){
         
         attendeeService.save(attendee);
         
         return "attendees?faces-redirect=true";
     }

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
     
     
            
}
