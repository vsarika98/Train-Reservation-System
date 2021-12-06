package com.capgemini.ttrms.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.ttrms.model.Admin;
import com.capgemini.ttrms.repository.AdminRepository;

@SpringBootTest
public class AdminServicesTest {

	@Autowired
	private AdminServices as;
	
	@MockBean
	private AdminRepository ar;
	
	@Test
	//@Ignore
	public void testCreateTrain(){

		Admin admin = new Admin();
		admin.setAdminId(31);
		admin.setAdminName("Janvi");
		admin.setPassword("Janv@p4");
	 	
		
	    Mockito.when(ar.save(admin)).thenReturn(admin);
	    
	    assertThat(as.createAdmin(admin)).isEqualTo(admin);
	
	}
}
