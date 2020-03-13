package com.madushan.accountservice.service;

import com.madushan.accountservice.model.APIResponse;
import com.madushan.accountservice.model.AccessToken;
import com.madushan.accountservice.model.CustomerDetails;
import com.madushan.accountservice.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Optional;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

  @Value("${authserver.clientid}")
  private String clientID;
  @Value("${authserver.clientsecret}")
  private String clientSecret;

  @Autowired
  CustomerDetailsRepository customerDetailsRepository;

  @Autowired
  private RestTemplate restTemplate;

  @Bean
  private RestTemplate getRestTemplate() {
    return new RestTemplate();
  }

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Bean
  private BCryptPasswordEncoder getbCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  public CustomerDetails save(CustomerDetails customerDetails) {
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
    CustomerDetails customerDetails = customerDetailsRepository.findByCustomerName(username);

    if (customerDetails != null) {
      if (!bCryptPasswordEncoder.matches(password, customerDetails.getPassword())) {
        // Call and get Access Token
        String authServerURL = "http://localhost:9595/oauth/token";
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

        ResponseEntity<AccessToken> responseEntity = restTemplate.exchange(
          authServerURL, HttpMethod.POST, httpEntity, AccessToken.class);

        return new APIResponse(200, "Successfull!", responseEntity.getBody());
      }
    }

    return new APIResponse(400, "Failed!");
  }


}
