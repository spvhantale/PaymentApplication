package com.vcriate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer walletId;
	
	private Integer walletBalance;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Transaction> transactions=new ArrayList<>();

	public Wallet(Integer walletBalance) {
		super();
		this.walletBalance = walletBalance;
	}
	
	
	
}
