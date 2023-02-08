package com.vcriate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vcriate.DTO.CustomerDTO;
import com.vcriate.DTO.LoginDTO;
import com.vcriate.Exception.CurrentUserSessionException;
import com.vcriate.Exception.CustomerException;
import com.vcriate.Exception.LoginException;
import com.vcriate.service.CustomerService;



@RestController
@RequestMapping("/vcriate")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody CustomerDTO customerDto) throws CustomerException{
		
		String message=customerService.registerCustomer(customerDto);
		
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
	}
	@PostMapping("/login")
	public ResponseEntity<String> loginCustomer(@RequestBody LoginDTO loginDto) throws CustomerException, LoginException, CurrentUserSessionException{
		
		String message=customerService.loginCustomer(loginDto);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> logoutCustomer(@RequestParam String key) throws CurrentUserSessionException{
		
		String message=customerService.logoutCustomer(key);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
}
