/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.shoppee.presentiation.shopping;

import com.javacourse.shoppee.business.shopping.boundary.ItemService;
import com.javacourse.shoppee.business.shopping.control.DuplicatedException;
import com.javacourse.shoppee.business.shopping.entity.Item;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omnifaces.util.Messages;

/**
 *
 * @author ardaacx
 */

@Named
@ViewScoped
public class ItemPresenter implements Serializable{
    
    @Inject
    private ItemService itemService;
    
    private Item item;
    
    private Long id;
    
   
    public void detail(){
    
        if(id!=null)
            item = itemService.find(id);
        else
            item = itemService.create();
    }
      
    public String save(){
        try {
            itemService.save(item);
        } catch (DuplicatedException ex) {
            Messages.create("Error!").error().detail("Name is already present").add();
            return "";
        }
    
        return "items?faces-redirect=true";
    }
    

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    
}
