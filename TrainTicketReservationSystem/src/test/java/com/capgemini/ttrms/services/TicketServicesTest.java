package com.capgemini.ttrms.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.ttrms.model.Ticket;
import com.capgemini.ttrms.repository.TicketRepository;

@SpringBootTest
public class TicketServicesTest {
	
	@Autowired
	private TicketService ts;
	
	@MockBean
	private TicketRepository tr;
	
	@Test
	public void testGetTicketDetailsByTicketId(){
		Optional<Ticket> ticket = Optional.of(new Ticket());
	 	ticket.get();
		
	    Mockito.when(tr.findById(15)).thenReturn(ticket);
	    assertThat(ts.getTicketDetailsById(15)).isEqualTo(ticket);
	}

}
