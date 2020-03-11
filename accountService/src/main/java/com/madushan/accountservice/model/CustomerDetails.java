package com.madushan.accountservice.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerName;
    private String email;
    private  String password;

    //map one to one relationship with customer address
    @OneToOne(cascade = CascadeType.ALL)
    private CustomerAddress customerAddress;

    public CustomerDetails() {

    }

    public CustomerDetails(int id, String customerName, String email, String password) {
        this.id = id;
        this.customerName = customerName;
        this.email = email;
        this.password = password;
    }

    public CustomerDetails(String customerName, String email, String password, CustomerAddress customerAddress) {
        this.customerName = customerName;
        this.email = email;
        this.password = password;
        this.customerAddress = customerAddress;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }



}
