package com.vcriate.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

	private String pincode;
	private String houseName;
	private String streetName;
	private String city;
}
