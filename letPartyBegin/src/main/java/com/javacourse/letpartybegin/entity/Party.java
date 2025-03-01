/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.letpartybegin.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ardaacx
 */


@Entity
public class Party {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private @NotBlank String partyName;
    private LocalDate partyTime;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private @NotEmpty List<Registration> registrations;
    
    public Party(){
        
        partyTime = LocalDate.now();
        registrations = new ArrayList<>();
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public LocalDate getPartyTime() {
        return partyTime;
    }

    public void setPartyTime(LocalDate partyTime) {
        this.partyTime = partyTime;
    }

    public List<Registration> getRegistration() {
        return registrations;
    }

    /*Public void setRegistration(List<Registration> registration) {
        this.registration = registration;
    }*/

    public void addRegistration(Registration registration) {
        
        if(!registrations.contains(registration)){
        
            registrations.add(registration);
            registration.setParty(this);
        
        }
        
        
    }
    
    
    
    
}
