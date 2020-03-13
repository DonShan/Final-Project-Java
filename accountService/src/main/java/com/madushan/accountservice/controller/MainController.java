package com.madushan.accountservice.controller;

import com.madushan.accountservice.model.APIResponse;
import com.madushan.accountservice.model.CustomerDetails;
import com.madushan.accountservice.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(value = "http://localhost:4200")
@RestController
@RequestMapping(value = "/customer")
public class MainController {

  @Autowired
  CustomerDetailsService customerDetailsService;

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String greeeting() {

    return "Hello world";
  }

  @RequestMapping(value = "/CustomerDetails", method = RequestMethod.POST)
  public CustomerDetails save(@RequestBody CustomerDetails customerDetails) {

    return customerDetailsService.save(customerDetails);
  }

  @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
  public Optional<CustomerDetails> findById(@PathVariable Integer id) {

    return customerDetailsService.findById(id);
  }

  @GetMapping(value = "/login/{username}/{password}")
  public APIResponse customerLogin(String username, String password) {
    return customerDetailsService.customerLogin(username, password);
  }
}
