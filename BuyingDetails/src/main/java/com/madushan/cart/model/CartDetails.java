package com.madushan.cart.model;

import javax.persistence.*;

@Entity
public class CartDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderNo;

    //private CustomerInfro CustomerInfo

    public CartDetails(int id, int orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

    public CartDetails() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }
}
