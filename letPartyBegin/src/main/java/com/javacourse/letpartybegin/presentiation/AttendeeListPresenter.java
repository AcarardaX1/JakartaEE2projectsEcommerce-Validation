/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.letpartybegin.presentiation;

import com.javacourse.letpartybegin.boundary.AttendeeService;
import com.javacourse.letpartybegin.entity.Attendee;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.model.JPALazyDataModel;



/**
 *
 * @author ardaacx
 */

@Named
@RequestScoped
public class AttendeeListPresenter {
    
    @Inject
    private AttendeeService attendeeService;
    
    private JPALazyDataModel<Attendee> lazyAttendees;
    
    
    @PostConstruct
    public void init(){
        lazyAttendees = JPALazyDataModel
                .<Attendee>builder()
                .entityClass(Attendee.class)
                .entityManager(()->attendeeService.getEm())
                .build();
    }

    public AttendeeService getAttendeeService() {
        return attendeeService;
    }

    public void setAttendeeService(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    public JPALazyDataModel<Attendee> getLazyAttendees() {
        return lazyAttendees;
    }

    public void setLazyAttendees(JPALazyDataModel<Attendee> lazyAttendees) {
        this.lazyAttendees = lazyAttendees;
    }
    
    
    
    
    
}
