/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.shoppee.presentiation.shopping;

import com.javacourse.shoppee.business.shopping.boundary.CartService;
import com.javacourse.shoppee.business.shopping.entity.Cart;
import com.javacourse.shoppee.business.shopping.entity.CartItem;
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
public class CartPresenter implements Serializable {

    @Inject
    private CartService cartService;

    private Cart cart;

    private Long id;

    public void detail() {

        if (id == null) {
            cart = cartService.create();
        } else {
            cart = cartService.find(id);
        }

    }

    public String save() {

        cartService.save(cart);

        return "carts?rfaces-redirect=true";
    }

    public void addCartItem() {

        cart.addCartItem(new CartItem());

    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
