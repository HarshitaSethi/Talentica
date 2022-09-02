/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.talentica.model;

import java.util.List;

/**
 *
 * @author harshita.sethi
 */
public class Product {

    private int storeId;
    private double productPrice;
    private List<String> bundledProduct;

    public Product(int storeId, double productPrice, List<String> bundledProduct) {
        this.storeId = storeId;
        this.productPrice = productPrice;
        this.bundledProduct = bundledProduct;
    }

    public Product() {
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public List<String> getBundledProduct() {
        return bundledProduct;
    }

    public void setBundledProduct(List<String> bundledProduct) {
        this.bundledProduct = bundledProduct;
    }

    @Override
    public String toString() {
        return "Product{" + "storeId=" + storeId + ", productPrice=" + productPrice + ", bundledProduct=" + bundledProduct + '}';
    }

}
