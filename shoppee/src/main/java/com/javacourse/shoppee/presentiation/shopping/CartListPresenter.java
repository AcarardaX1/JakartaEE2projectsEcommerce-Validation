/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.shoppee.presentiation.shopping;

import com.javacourse.shoppee.business.shopping.boundary.CartService;
import com.javacourse.shoppee.business.shopping.entity.Cart;
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
public class CartListPresenter {
    
    @Inject
    private CartService cartService;
    
    public List<Cart> getCarts(){
        
        return cartService.list();
        
    }
    
    
    public void delete(Long id){
    
        if(id != null)
            cartService.delete(id);
        
   }
    
    
    
    
}


