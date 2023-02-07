package com.vcriate.model;

import java.time.LocalDateTime;

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
public class CurrentUserSession {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer currentUserId;
	private String email;
	private String key;
	private LocalDateTime date;
	
	public CurrentUserSession(String email, String key, LocalDateTime date) {
		super();
		this.email = email;
		this.key = key;
		this.date = date;
	}
	
}
