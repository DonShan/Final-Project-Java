package com.madushan.accountservice.controller;

import com.madushan.accountservice.model.APIResponse;
import com.madushan.accountservice.model.CustomerDetails;
import com.madushan.accountservice.model.LoginRequest;
import com.madushan.accountservice.service.CustomerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @RequestMapping(value = {"", "/CustomerDetails"}, method = RequestMethod.POST)
  public ResponseEntity<Object> save(@RequestBody CustomerDetails customerDetails) {
    if (customerDetails.getCustomerName() == null || customerDetails.getPassword() == null) {
      return ResponseEntity.badRequest().body(new APIResponse(400, "customerName and password are required"));
    }
    if (customerDetailsService.findByCustomerName(customerDetails.getCustomerName()) != null) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body(new APIResponse(409, "Customer name already exists"));
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(customerDetailsService.save(customerDetails));
  }

  @RequestMapping(value = {"/{id}", "/customer/{id}"}, method = RequestMethod.GET)
  public ResponseEntity<CustomerDetails> findById(@PathVariable Integer id) {

    return ResponseEntity.of(customerDetailsService.findById(id));
  }

  @PostMapping(value = "/login")
  public ResponseEntity<APIResponse> customerLogin(@RequestBody LoginRequest loginRequest) {
    return toResponse(customerDetailsService.customerLogin(loginRequest.getUsername(), loginRequest.getPassword()));
  }

  // kept for the Angular client; prefer POST /customer/login so the password is not in the URL
  @GetMapping(value = "/login/{username}/{password}")
  public ResponseEntity<APIResponse> customerLogin(@PathVariable String username, @PathVariable String password) {
    return toResponse(customerDetailsService.customerLogin(username, password));
  }

  private ResponseEntity<APIResponse> toResponse(APIResponse apiResponse) {
    return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
  }
}
