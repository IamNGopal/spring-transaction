package com.springtransaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springtransaction.model.SalesOppr;

@Repository
public interface OpprRepo extends JpaRepository<SalesOppr, Integer>{

}
