package com.vcriate.model;


import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transactionId;
	private LocalDateTime date;
	private Integer transactionAmount;
	private boolean credit=false;
	private boolean debit=false;
	
	

	public Transaction(LocalDateTime date, Integer transactionAmount, boolean credit, boolean debit) {
		super();
		this.date = date;
		this.transactionAmount = transactionAmount;
		this.credit = credit;
		this.debit = debit;
	}
	
}
