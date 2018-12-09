package com.springtransaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtransaction.model.CustomerContact;

@Repository
public interface ContactRepo extends JpaRepository<CustomerContact, Integer>{

}
