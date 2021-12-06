package com.capgemini.ttrms.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.ttrms.model.Booking;
import com.capgemini.ttrms.repository.BookingRepository;

@SpringBootTest
public class BookingServicesTest {
	@Autowired
	private BookingServices bs;
	
	@MockBean
	private BookingRepository br;
	
	@Test
	//@Ignore
	public void testCreateTrain(){

		Booking booking = new Booking();

	 	
		
	    Mockito.when(br.save(booking)).thenReturn(booking);
	    
	    assertThat(bs.createBooking(booking)).isEqualTo(booking);
	
	}
}
