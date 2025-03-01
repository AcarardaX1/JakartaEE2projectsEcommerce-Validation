/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.letpartybegin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import jakarta.persistence.Entity ;
import com.javacourse.letpartybegin.entity.Attendee;

/**
 *
 * @author ardaacx
 */

@Entity
public class Registration {
    
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column(unique=true)
    private @NotBlank
    LocalDate arrivalDate;
    
    @Column(unique=true)
    private @NotBlank
    LocalDate timeCheckin;

 
    
    
    @OneToOne(optional = false)
    private @NotNull Party party;
    
    @OneToOne(optional = false)
    private @NotNull Attendee attendee;

    public Registration() {
        this.arrivalDate = arrivalDate;
        this.timeCheckin = timeCheckin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getTimeCheckin() {
        return timeCheckin;
    }

    public void setTimeCheckin(LocalDate timeCheckin) {
        this.timeCheckin = timeCheckin;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Attendee getAttendee() {
        return attendee;
    }

    public void setAttendee(Attendee attendee) {
        this.attendee = attendee;
    }
    
    
    
    
}
