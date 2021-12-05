package com.train.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.train.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {

	List<Ticket> findByPnrNumber(long pnr);

}
