package com.commercehub.IMS.main.model;

import com.commercehub.IMS.main.Abstracts.AbstractProduct;

/**
 * Created by yoges on 7/20/2016.
 */
public class Product extends AbstractProduct {
    private String name;
    private String description;

    public Product() {
        super();
    }

    public Product(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
