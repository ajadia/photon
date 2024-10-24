package com.photon.order.bean;

import java.util.Date;

public class Order {

    int id;
    String customerName;
    Products products;
    Date orderDate;

    public Order() {
    }

    public Order(int id, String customerName, Products products, Date orderDate) {
        this.id = id;
        this.customerName = customerName;
        this.products = products;
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
