package com.madushan.accountservice.repository;

import com.madushan.accountservice.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer> {


    /*Optional<CustomerDetails> findById(CustomerDetails integer);*/

    CustomerDetails findByCustomerName(String name);

    CustomerDetails findByEmail(String email);

    /*CustomerDetails findAllBy(int customerId);*/
}
