package com.upgrad.FoodOrderingApp.api.controller;


import com.upgrad.FoodOrderingApp.service.businness.CustomerService;
import com.upgrad.FoodOrderingApp.service.entity.CustomerEntity;
import com.upgrad.FoodOrderingApp.service.exception.SignUpRestrictedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.upgrad.FoodOrderingApp.api.model.*;

import java.util.UUID;


@RestController
@RequestMapping("/customer")
public class CustomerController {


	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.POST, path = "/signup", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   public ResponseEntity<SignupCustomerResponse> signUp(@RequestBody final SignupCustomerRequest signupCustomerRequest)
			throws SignUpRestrictedException {

		//validate this request.

		if(signupCustomerRequest.getLastName().isEmpty()) {
			throw new SignUpRestrictedException("SGR -005", "Last name cannot be empty");
		}

		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setContactNumber("12345cds6237890");
		customerEntity.setEmailAddress("testing@teasst.com");
		customerEntity.setLastname("lsatname");
		customerEntity.setFirstName("first");
		customerEntity.setPassword("password");
		customerEntity.setSalt("salt");
		customerEntity.setUuid(UUID.randomUUID().toString());

		final CustomerEntity responseCustomer = customerService.saveCustomer(customerEntity);
		SignupCustomerResponse signupCustomerResponse = new SignupCustomerResponse();
		signupCustomerResponse.setId(responseCustomer.getUuid());
		signupCustomerResponse.setStatus("Customer Registered");
		return new ResponseEntity<SignupCustomerResponse>(signupCustomerResponse, HttpStatus.CREATED);
   }


   @RequestMapping(method = RequestMethod.POST, path = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
   public ResponseEntity<LoginResponse> login(@RequestHeader("authorization") final String auth) {

		//call to service to login

	   //Use https://www.base64encode.org/ to create the encoded string

	   //pass that encoded string in request header.

	   //decode that string and get the password and contact number(On upgrad's portal there is a seperate lecture for this, see that one).

	   // After decoding it check if that contact number exist in database if not then throw exception otherwise encrypt the decoded
	   // password and check with password if matched then create a random string

	   // create one more table customerAuthEntity and store this string and current time inside that table and customer also.

	   //set that random string in response headers and return it in response.

	   LoginResponse loginResponse = new LoginResponse();
	   return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
   }









}
