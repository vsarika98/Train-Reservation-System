package com.capgemini.ttrms.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.ttrms.model.Customer;
import com.capgemini.ttrms.repository.CustomerRepository;


@SpringBootTest
public class CustomerServicesTest {
	
	@Autowired
	private CustomerServices cs;
	
	@MockBean
	private CustomerRepository cr;

	@Test
	public void testGetTrainDetailsByTrainNo(){
		Optional<Customer> cust = Optional.of(new Customer());
	 	cust.get();
		
	    Mockito.when(cr.findById(12)).thenReturn(cust);
	    assertThat(cs.getCustomerDetailsById(12)).isEqualTo(cust);
	}
}
