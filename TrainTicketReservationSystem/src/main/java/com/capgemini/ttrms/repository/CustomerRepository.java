package com.capgemini.ttrms.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ttrms.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	List<Customer> findByCustomerId(int cI);
	List<Customer> findByCustomerName(String bName);
	List<Customer> findBygender(String gName);
	
	
}