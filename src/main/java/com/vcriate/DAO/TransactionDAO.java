package com.vcriate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.model.Transaction;

@Repository
public interface TransactionDAO extends JpaRepository<Transaction, Integer>{

}
