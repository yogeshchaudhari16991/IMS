package com.commercehub.IMS.main.model;

import com.commercehub.IMS.main.Abstracts.AbstractProduct;

import java.util.HashMap;

import static com.commercehub.IMS.main.model.ProductExtensions.getNewProduct;

/**
 * Created by yoges on 7/20/2016.
 */
public class Inventory {
    private HashMap<String, AbstractProduct> inventory = new HashMap<>();

    private void addProduct(AbstractProduct p){
        inventory.put(p.getProductID(), p);
    }

    public AbstractProduct getProduct(String productID) {
        return inventory.get(productID);
    }

    public void addProductToInventory(String productId, String name, String description, String zone, String section, int level) {
        AbstractProduct p = getNewProduct(productId, name, description, zone, section, level);
        addProduct(p);
    }
}
