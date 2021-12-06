package com.capgemini.ttrms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ttrms.model.Customer;
import com.capgemini.ttrms.repository.CustomerRepository;

@Service
public class CustomerServices {
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer); 
												
	}
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	public Optional<Customer> getCustomerDetailsById(int customerId) {
	
		return customerRepository.findById(customerId);
	}
	
	public void deleteCustomerDetailsById(int customerId) {
		customerRepository.deleteById(customerId);
	}
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer); 
	}
	 
	public List<Customer> getAllCustomersByName(String customerName){  
		return customerRepository.findByCustomerName(customerName);
	}
	public List<Customer> getCustomerDetailsByGender(String gender) {
		
		return customerRepository.findBygender(gender);
	}
//	public void signInAuthentication(String signin) {
//	}
//	public void signout() {
//	}
	
}
