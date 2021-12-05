package com.ticket.Repository;




import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ticket.model.Ticket;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer>{


List<Ticket> findByTicketName(String cName);
List<Ticket> findByTicketId(int id);
Ticket save(Ticket ticket);
List<Ticket> findAll();
Optional<Ticket> findById(int ticketId);
void deleteById(int ticketId);






}