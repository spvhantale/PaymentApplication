package com.vcriate.service.Impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.DAO.AddressDAO;
import com.vcriate.DAO.CurrentUserDAO;
import com.vcriate.DAO.CustomerDAO;
import com.vcriate.DAO.WalletDAO;
import com.vcriate.DTO.AddressDTO;
import com.vcriate.DTO.CustomerDTO;
import com.vcriate.DTO.LoginDTO;
import com.vcriate.Exception.CurrentUserSessionException;
import com.vcriate.Exception.CustomerException;
import com.vcriate.Exception.LoginException;
import com.vcriate.model.Address;
import com.vcriate.model.UserSession;
import com.vcriate.model.Customer;
import com.vcriate.model.Wallet;
import com.vcriate.service.CustomerService;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDao;
	@Autowired
	private AddressDAO addressDao;
	@Autowired
	private CurrentUserDAO currentUserDao;
	@Autowired
	private WalletDAO walletDao;
	
	@Override
	public String registerCustomer(CustomerDTO customerDto) throws CustomerException {

		Optional<Customer> customer=customerDao.findByEmail(customerDto.getEmail());

		if(customer.isPresent()) {
			throw new CustomerException("Customer already present");
		}else {
			Wallet wallet=new Wallet(0);
			Wallet wall=walletDao.save(wallet);
			AddressDTO add=customerDto.getAddress();
			
			Address address=new Address(add.getPincode(), add.getHouseName(), add.getStreetName(), add.getCity());
			Address addr=addressDao.save(address);
			Customer custom=new Customer(customerDto.getEmail(), customerDto.getFirstName(), customerDto.getLastName(), customerDto.getPassword(), customerDto.getPhoneNumber(), addr, wall);
			Customer c=customerDao.save(custom);
			return "Register successfully "+c.getFirstName();
		}
	}

	@Override
	public String loginCustomer(LoginDTO loginDto) throws CustomerException,LoginException ,CurrentUserSessionException {
		
		Optional<UserSession> curr=currentUserDao.findByEmail(loginDto.getEmail());
		if(curr.isPresent()) {
			throw new CurrentUserSessionException("Already login");
		}else {
			Optional<Customer> cust=customerDao.findByEmail(loginDto.getEmail());
			if(cust.isPresent()) {
				Customer cu=cust.get();
				if(loginDto.getPassword().equals(cu.getPassword())) {
					String key=RandomString.make(6);
					UserSession current=new UserSession(loginDto.getEmail(), key,LocalDateTime.now());
					UserSession cur=currentUserDao.save(current);
					return "Key is "+cur.getUuid();
				}else {
					throw new LoginException("Password is wrong");
				}
				
			}else {
				throw new CustomerException("Customer not present");
			}
		}
		
	}

	@Override
	public String logoutCustomer(String key) throws CurrentUserSessionException {
	
		Optional<UserSession> curr=currentUserDao.findByUuid(key);
		
		if(curr.isPresent()) {
			currentUserDao.delete(curr.get());
			return "Logout Successfully";
		}else {
			throw new CurrentUserSessionException("Key is wrong");
		}
		
	}

}
