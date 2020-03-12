package com.madushan.accountservice.service;

import com.madushan.accountservice.model.CustomerDetails;

import java.util.Optional;

public interface CustomerDetailsService {

    CustomerDetails save(CustomerDetails customerDetails);

    Optional<CustomerDetails> findById(Integer id);

    CustomerDetails findByCustomerName(String Name);

    CustomerDetails findByEmail(String Email);

}
