package com.customer.controller;


import java.util.List;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;

import io.swagger.models.Model;

import com.customer.Service.CustomerService;

@RestController
public class CustomerController {

		@Autowired
		private CustomerService customerService;
		
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String welcome() {
			return "Welcome to Customer module";
		}
		
		
		
		@RequestMapping(value="/customer", method=RequestMethod.POST )
		public Customer createCustomer(@Valid @RequestBody Customer customer) {
			return customerService.createCustomer(customer);
		}
		
		@RequestMapping(value="/customer", method=RequestMethod.GET )
		public List<Customer> getAllCustomers() {
			return customerService.getAllCustomer(); // List<Bank>
		}
		
		@RequestMapping(value="/customer/{customerId}", method=RequestMethod.GET )
		public Customer getCustomerDetailsById(@PathVariable("customerId") int cId) {
			Optional<Customer> customer = customerService.getCustomerDetailsById(cId);
			return customer.get();
			
		}
	
		@RequestMapping(value="/customer/gender/{gender}", method=RequestMethod.GET )
		public List<Customer> getCustomerDetailsByGender(@PathVariable("gender") String gender) {
			return customerService.getCustomerDetailsByGender(gender);
			
		}
		
		
		@RequestMapping(value="/customer", method=RequestMethod.PUT )
		public Customer updateCustomerDetails(@RequestBody Customer customer) {
			return customerService.updateCustomer(customer);	
		}
		
		
		
		@RequestMapping(value="/customer/{customerId}", method=RequestMethod.DELETE)
		public String deleteCustomerDetails(@PathVariable("customerId") int cId) {
			Optional<Customer> c = customerService.getCustomerDetailsById(cId);
			if(c.isPresent()) {
				customerService.deleteCustomerDetailsById(cId);
				return "The Customer Details deleted with the customer ID: "+cId;
			}
			
			return "The Customer Details Not deleted with the customer ID: "+cId;
			
		}
}


