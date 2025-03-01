/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.letpartybegin.presentiation;

import com.javacourse.letpartybegin.boundary.PartyService;
import com.javacourse.letpartybegin.entity.Party;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author ardaacx
 */
@Named
@RequestScoped
public class PartyListPresenter {
    
    @Inject
    private PartyService partyService;
    
    public List<Party> getParties(){
    
        
       return partyService.list(); 
    }
    
    
    public void delete(Long id){
    
    
    if(id != null)
        partyService.delete(id);
                }
    
}
