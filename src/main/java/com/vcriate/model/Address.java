package com.vcriate.model;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	private String pincode;
	private String houseName;
	private String streetName;
	private String city;
	public Address(String pincode, String houseName, String streetName, String city) {
		super();
		this.pincode = pincode;
		this.houseName = houseName;
		this.streetName = streetName;
		this.city = city;
	}
	
	
}
