package com.madushan.accountservice.service;

import com.madushan.accountservice.model.CustomerDetails;
import com.madushan.accountservice.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Override
    public CustomerDetails save(CustomerDetails customerDetails) {
        return  customerDetailsRepository.save(customerDetails);
    }


}
