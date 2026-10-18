package com.madushan.accountservice.service;

import com.madushan.accountservice.model.APIResponse;
import com.madushan.accountservice.model.AccessToken;
import com.madushan.accountservice.model.CustomerDetails;
import com.madushan.accountservice.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

  @Value("${authserver.clientid}")
  private String clientID;
  @Value("${authserver.clientsecret}")
  private String clientSecret;
  @Value("${authserver.url}")
  private String authServerURL;

  @Autowired
  CustomerDetailsRepository customerDetailsRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Override
  public CustomerDetails save(CustomerDetails customerDetails) {
    // store only the hash so customerLogin can verify it with bcrypt
    customerDetails.setPassword(bCryptPasswordEncoder.encode(customerDetails.getPassword()));
    return customerDetailsRepository.save(customerDetails);
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
    return customerDetailsRepository.findByEmail(Email);
  }

  @Override
  public APIResponse customerLogin(String username, String password) {
    if (username == null || password == null) {
      return new APIResponse(400, "Username and password are required");
    }

    CustomerDetails customerDetails = customerDetailsRepository.findByCustomerName(username);

    if (customerDetails == null || !bCryptPasswordEncoder.matches(password, customerDetails.getPassword())) {
      return new APIResponse(401, "Invalid username or password");
    }

    // Call and get Access Token
    String clientCredentials = clientID + ":" + clientSecret;
    String authBasicHeaderClient = "Basic " + Base64.getEncoder().encodeToString(clientCredentials.getBytes());

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.set(HttpHeaders.AUTHORIZATION, authBasicHeaderClient);
    httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
    multiValueMap.add("username", username);
    multiValueMap.add("password", password);
    multiValueMap.add("grant_type", "password");

    HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(multiValueMap, httpHeaders);

    try {
      ResponseEntity<AccessToken> responseEntity = restTemplate.exchange(
        authServerURL, HttpMethod.POST, httpEntity, AccessToken.class);
      return new APIResponse(200, "Successfull!", responseEntity.getBody());
    } catch (RestClientException e) {
      return new APIResponse(502, "Could not get access token from authorization server");
    }
  }


}
