package com.vcriate.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrasactionDTO {

	private Integer transactionAmount;
	private boolean credit=false;
	private boolean debit=false;
}
