package com.vcriate.service;

import com.vcriate.DTO.CustomerDTO;
import com.vcriate.DTO.LoginDTO;
import com.vcriate.Exception.CurrentUserSessionException;
import com.vcriate.Exception.CustomerException;
import com.vcriate.Exception.LoginException;

public interface CustomerService {

	public String registerCustomer(CustomerDTO customerDto) throws CustomerException;
	
	public String loginCustomer(LoginDTO loginDto)throws CustomerException,LoginException, CurrentUserSessionException;
	
	public String logoutCustomer(String key) throws CurrentUserSessionException;
	
}
