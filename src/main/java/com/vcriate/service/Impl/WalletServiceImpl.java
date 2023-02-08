package com.vcriate.service.Impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcriate.DAO.CurrentUserDAO;
import com.vcriate.DAO.CustomerDAO;
import com.vcriate.DAO.TransactionDAO;
import com.vcriate.DAO.WalletDAO;
import com.vcriate.Exception.CurrentUserSessionException;
import com.vcriate.Exception.WalletException;
import com.vcriate.model.UserSession;
import com.vcriate.model.Customer;
import com.vcriate.model.Transaction;
import com.vcriate.model.Wallet;
import com.vcriate.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	private CustomerDAO customerDao;
	@Autowired
	private CurrentUserDAO currentUserDao;
	@Autowired
	private WalletDAO walletDao; 
	@Autowired
	private TransactionDAO tranDao;

	
	@Override
	public String creditAmount(Integer amount, String key) throws WalletException, CurrentUserSessionException {
		
		Optional<UserSession> curr=currentUserDao.findByUuid(key);
		
		if(curr.isPresent()) {
			Optional<Customer> cust=customerDao.findByEmail(curr.get().getEmail());
			if(cust.isPresent()) {
				Customer customer=cust.get();
				Wallet wall=customer.getWallet();
				wall.setWalletBalance(wall.getWalletBalance()+amount);
				
				Transaction transaction=new Transaction(LocalDateTime.now(), amount, true, false);
				Transaction tr=tranDao.save(transaction);
				wall.getTransactions().add(tr);
				Wallet w=walletDao.save(wall);
				return "Amount credited successfully "+amount+" and your total amount is "+w.getWalletBalance();
			}else { 
				throw new CurrentUserSessionException("User is not present");
			}
		}else {
			throw new CurrentUserSessionException("User not present");
		}
	}

	@Override
	public String debitAmount(Integer amount, String key) throws WalletException, CurrentUserSessionException {
		Optional<UserSession> curr=currentUserDao.findByUuid(key);
		
		if(curr.isPresent()) {
			Optional<Customer> cust=customerDao.findByEmail(curr.get().getEmail());
			if(cust.isPresent()) {
				Customer customer=cust.get();
				Wallet wall=customer.getWallet();
				if(wall.getWalletBalance()>=amount) {
					wall.setWalletBalance(wall.getWalletBalance()-amount);
					Transaction transaction=new Transaction(LocalDateTime.now(), amount, false, true);
					Transaction tr=tranDao.save(transaction);
					wall.getTransactions().add(tr);
					Wallet w=walletDao.save(wall);
					return "Amount debited successfully "+amount+" total amount is "+w.getWalletBalance();
				}else {
					throw new WalletException("amount is not present "+amount);
				}
			}else {
				throw new CurrentUserSessionException("User is not present");
			}
		}else {
			throw new CurrentUserSessionException("User not present");
		}
	}

	@Override
	public String checkAmount(String key) throws CurrentUserSessionException {
		Optional<UserSession> curr=currentUserDao.findByUuid(key);
		
		if(curr.isPresent()) {
			Optional<Customer> cust=customerDao.findByEmail(curr.get().getEmail());
			if(cust.isPresent()) {
				Customer customer=cust.get();
				Wallet wall=customer.getWallet();
				return "Amount is "+ wall.getWalletBalance();
			}else {
				throw new CurrentUserSessionException("User not present");
			}
		}else {
			throw new CurrentUserSessionException("Key is wrong "+key);
		}
		
	}

	@Override
	public List<Transaction> checkTrasaction(String key) throws CurrentUserSessionException {
		Optional<UserSession> curr=currentUserDao.findByUuid(key);
		if(curr.isPresent()) {
			Optional<Customer> cust=customerDao.findByEmail(curr.get().getEmail());
			if(cust.isPresent()) {
				Customer customer=cust.get();
				Wallet wall=customer.getWallet();
				
				List<Transaction> tranList=wall.getTransactions();
				System.out.println(tranList);
				return tranList;
			}else {
				throw new CurrentUserSessionException("User not present");
			}
		}else {
			throw new CurrentUserSessionException("Key is wrong "+key);
		}
	}

}
