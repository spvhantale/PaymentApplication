package com.vcriate.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String phoneNumber;
	private AddressDTO address;
}
