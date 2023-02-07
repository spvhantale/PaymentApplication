package com.vcriate.DAO;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcriate.model.Address;

@Repository
public interface AddressDAO extends JpaRepository<Address, Integer>{

}
