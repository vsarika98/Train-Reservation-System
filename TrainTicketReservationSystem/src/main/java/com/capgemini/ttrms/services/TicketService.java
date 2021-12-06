package com.capgemini.ttrms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ttrms.model.Ticket;
import com.capgemini.ttrms.repository.TicketRepository;


@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepository;

	public Ticket createTicket(Ticket ticket) {
	return ticketRepository.save(ticket); // persist - javax.persistence API

	}
	public List<Ticket> getAllTicket(){
	return ticketRepository.findAll();
	}

	public Optional<Ticket> getTicketDetailsById(int ticketId) {

	return ticketRepository.findById(ticketId);
	}

	public void deleteTicketDetailsById(int ticketId) {
		ticketRepository.deleteById(ticketId);
	}
	public Ticket updateTicket(Ticket ticket) {
	return ticketRepository.save(ticket); // if the bsnkId already exists in the db merge // if the bankId is not there in db then persist
	}

	public List<Ticket> getAllTicketByName(long pnr){ // Query Generation
	return ticketRepository.findByPnrNumber(pnr);
	}
}
