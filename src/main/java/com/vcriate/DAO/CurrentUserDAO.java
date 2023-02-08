package com.vcriate.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.model.UserSession;

@Repository
public interface CurrentUserDAO extends JpaRepository<UserSession, Integer>{

	public Optional<UserSession> findByEmail(String email);
	public Optional<UserSession> findByUuid(String uuid);
}
