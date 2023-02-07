package com.vcriate.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.model.CurrentUserSession;

@Repository
public interface CurrentUserDAO extends JpaRepository<CurrentUserSession, Integer>{

	public Optional<CurrentUserSession> findByEmail(String email);
	public Optional<CurrentUserSession> findByKey(String key);
}
