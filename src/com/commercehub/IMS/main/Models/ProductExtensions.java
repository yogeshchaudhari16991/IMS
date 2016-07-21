package com.commercehub.IMS.main.Models;

import com.commercehub.IMS.main.Abstracts.AbstractProduct;

/**
 * Created by yoges on 7/20/2016.
 */
public class ProductExtensions {
    public static AbstractProduct getNewProduct(String productId, String name, String description, String zone, String section, int level){
        Product p = new Product();
        p.setProductID(productId);
        p.setName(name);
        p.setDescription(description);
        Location loc = new Location();
        loc.setSection(section);
        loc.setZone(zone);
        p.setLocation(loc);
        p.setLevel(level);
        return p;
    }

    public static int getLevel(AbstractProduct p) {
        return p.getLevel();
    }
}
