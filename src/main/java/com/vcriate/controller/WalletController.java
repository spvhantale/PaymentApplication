package com.vcriate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vcriate.Exception.CurrentUserSessionException;
import com.vcriate.Exception.WalletException;
import com.vcriate.model.Transaction;
import com.vcriate.service.WalletService;

@RestController
@RequestMapping("/vcriate")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	
	@PutMapping("/credit/{amount}")
	public ResponseEntity<String> creditAmount(@PathVariable("amount") Integer amount,@RequestParam String key) throws WalletException, CurrentUserSessionException{
		
		String message=walletService.creditAmount(amount, key);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	@PutMapping("/debit/{amount}")
	public ResponseEntity<String> debitAmount(@PathVariable("amount") Integer amount,@RequestParam String key) throws WalletException, CurrentUserSessionException{
		
		String message=walletService.debitAmount(amount, key);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	@GetMapping("/wallet")
	public ResponseEntity<String> checkWallet(@RequestParam String key) throws WalletException, CurrentUserSessionException{
		
		String message=walletService.checkAmount(key);
		
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	@GetMapping("/transaction")
	public ResponseEntity<List<Transaction>> checktransaction(@RequestParam String key) throws WalletException, CurrentUserSessionException{
		
		List<Transaction> tranList=walletService.checkTrasaction(key);
		
		return new ResponseEntity<List<Transaction>>(tranList, HttpStatus.OK);
	}
	
}
