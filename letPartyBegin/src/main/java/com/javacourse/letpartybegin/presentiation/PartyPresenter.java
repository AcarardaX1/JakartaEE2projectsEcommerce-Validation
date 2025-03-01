/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.letpartybegin.presentiation;

import com.javacourse.letpartybegin.boundary.PartyService;
import com.javacourse.letpartybegin.entity.Party;
import com.javacourse.letpartybegin.entity.Registration;
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
public class PartyPresenter implements Serializable {
    
    
    @Inject
    private PartyService partyService;
    
    private Party party;
    
    private Long id;
    
    public void detail(){
        
        if(id==null){
            party = partyService.create();
        }else{
        
            party = partyService.find(id);
        }
    
    
    }
    
    
    public String save() {
    
        partyService.save(party);
        
        return "parties?rfaces-redirect=true";
    }
    
    
    public void addRegistration(){
        
        party.addRegistration(new Registration());
        
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    
    
}
