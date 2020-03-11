package com.madushan.accountservice.controller;

import com.madushan.accountservice.model.CustomerDetails;
import com.madushan.accountservice.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class MainController {

    @Autowired
    CustomerDetailsService customerDetailsService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeeting(){

        return "Hello world";
    }


    @RequestMapping(value = "/CustomerDetails", method = RequestMethod.POST)
    public CustomerDetails save(@RequestBody CustomerDetails customerDetails){

        return  customerDetailsService.save(customerDetails);
    }


}
