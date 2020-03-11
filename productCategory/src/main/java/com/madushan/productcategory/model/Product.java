package com.madushan.productcategory.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String productname;
    private  int quentity;
    private int price;

    public Product(int pid, String productName, int quentity, int price) {
        this.pid = pid;
        this.productname = productName;
        this.quentity = quentity;
        this.price = price;
    }

    public Product() {

    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productname;
    }

    public void setProductName(String productName) {
        this.productname = productName;
    }

    public int getQuentity() {
        return quentity;
    }

    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
