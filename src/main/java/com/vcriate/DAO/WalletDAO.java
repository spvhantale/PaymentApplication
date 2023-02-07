package com.vcriate.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.model.Wallet;

@Repository
public interface WalletDAO extends JpaRepository<Wallet, Integer>{

	
}
