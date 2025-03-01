/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.shoppee.business.shopping.entity;

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
public class Cart {
 
    
    @Id
    @GeneratedValue
    private Long id;
    
    private @NotBlank String name;
    
    private LocalDate created;
    
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private @NotEmpty List<CartItem> cartItems;
    
    public Cart(){
        created = LocalDate.now();
        cartItems = new ArrayList<>();
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addCartItem(CartItem cartItem) {
        
        if(!cartItems.contains(cartItem)){
            
            cartItems.add(cartItem);
            cartItem.setCart(this);
        
        }

    }
    
    
    public void removeCartItem(CartItem cartItem){
    
        cartItem.setCart(null);
        cartItems.remove(cartItem);
    
    }
    
}


