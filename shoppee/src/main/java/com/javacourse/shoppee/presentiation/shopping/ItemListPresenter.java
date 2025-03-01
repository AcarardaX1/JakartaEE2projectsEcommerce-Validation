/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javacourse.shoppee.presentiation.shopping;

import com.javacourse.shoppee.business.shopping.boundary.ItemService;
import com.javacourse.shoppee.business.shopping.entity.Item;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import org.primefaces.model.JPALazyDataModel;
import static org.primefaces.model.JPALazyDataModel.builder;

/**
 *
 * @author ardaacx
 */

@Named
@RequestScoped
public class ItemListPresenter {
    
    @Inject
    private ItemService itemService;
    
    private JPALazyDataModel<Item> lazyItems;
    
    @PostConstruct
    public void init(){
        lazyItems = JPALazyDataModel.<Item>builder().entityClass(Item.class).entityManager(()->itemService.getEm()).build();
        
        
    }
    
    public List<Item> getItems(){
        return itemService.list();
    }
    
    
    public void delete(Long id){
        itemService.delete(id);
    }

    public JPALazyDataModel<Item> getLazyItems() {
        return lazyItems;
    }

    public void setLazyItems(JPALazyDataModel<Item> lazyItems) {
        this.lazyItems = lazyItems;
    }
    
    
}
