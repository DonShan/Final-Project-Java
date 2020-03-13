package com.madushan.accountservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "customer_address")
public class CustomerAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int addressNo;
  private String street;
  private String city;


  public CustomerAddress() {

  }

  public CustomerAddress(int id, int addressNo, String street, String city, String country) {
    this.id = id;
    this.addressNo = addressNo;
    this.street = street;
    this.city = city;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAddressNo() {
    return addressNo;
  }

  public void setAddressNo(int addressNo) {
    this.addressNo = addressNo;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

}
