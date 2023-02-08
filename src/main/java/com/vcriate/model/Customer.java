package com.vcriate.model;






import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String phoneNumber;
	@OneToOne(cascade = CascadeType.ALL)
	private Address Address;
	@OneToOne(cascade = CascadeType.ALL)
	private Wallet wallet;
	
}
