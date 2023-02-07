package com.vcriate.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.model.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, String>{

	public Optional<Customer> findByEmail(String email);
}
