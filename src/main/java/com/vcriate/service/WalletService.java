package com.vcriate.service;

import java.util.List;

import com.vcriate.Exception.CurrentUserSessionException;
import com.vcriate.Exception.WalletException;
import com.vcriate.model.Transaction;

public interface WalletService {

	public String creditAmount(Integer amount,String key)throws WalletException,CurrentUserSessionException;
	public String debitAmount(Integer amount,String key) throws WalletException,CurrentUserSessionException;
	public String checkAmount(String key)throws CurrentUserSessionException;
	public List<Transaction> checkTrasaction(String key) throws CurrentUserSessionException;
	
}
