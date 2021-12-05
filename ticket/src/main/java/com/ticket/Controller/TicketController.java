package com.ticket.Controller;

import java.util.List;
import java.util.Optional;



import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.ticket.model.Ticket;
import com.ticket.Service.TicketService;



@RestController

public class TicketController {
	@Autowired
	private TicketService ticketService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
	return "Welcome first Spring boot project";
	}

	@RequestMapping(value="/ticket", method=RequestMethod.POST )
	public Ticket createTicket(@RequestBody Ticket ticket) {
	return ticketService.createTicket(ticket);
	}

	@RequestMapping(value="/ticket", method=RequestMethod.GET )
	public List<Ticket> getAllTicket() {
	return ticketService.getAllTicket();
	}

	@RequestMapping(value="/ticket/{ticketId}", method=RequestMethod.GET )
	public Ticket getTicketDetailsById(@PathVariable("ticketId") int cId) {
	Optional<Ticket> ticket = ticketService.getTicketDetailsById(cId);
	return ticket.get();

	}


	@RequestMapping(value="/ticket", method=RequestMethod.PUT )
	public Ticket updateTicketDetails(@RequestBody Ticket ticket) {
	return ticketService.createTicket(ticket);
	}
	@RequestMapping(value="/ticket/{ticketId}", method=RequestMethod.DELETE)
	public String deleteTicketDetails(@PathVariable("ticketId") int cId) {
	Optional<Ticket> c = ticketService.getTicketDetailsById(cId);
	if(c.isPresent()) {
		ticketService.deleteTicketDetailsById(cId);
	return "The Ticket Details deleted with the ticket ID: "+cId;
	}

	return "The Ticket Details Not deleted with the ticket ID: "+cId;

	}

}
