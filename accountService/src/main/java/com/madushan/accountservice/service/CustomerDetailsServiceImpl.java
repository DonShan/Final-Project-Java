package com.madushan.accountservice.service;

import com.madushan.accountservice.model.CustomerDetails;
import com.madushan.accountservice.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Override
    public CustomerDetails save(CustomerDetails customerDetails) {
        return  customerDetailsRepository.save(customerDetails);
    }

    @Override
    public Optional<CustomerDetails> findById(Integer id) {
        return customerDetailsRepository.findById(id);
    }


    @Override
    public CustomerDetails findByCustomerName(String Name) {

        return customerDetailsRepository.findByCustomerName(Name);
    }

    @Override
    public CustomerDetails findByEmail(String Email) {
        return  customerDetailsRepository.findByEmail(Email);
    }


}
