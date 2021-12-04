package com.train.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.train.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

//	@Query("select b from Booking b where b.bookingName=?1")
	//public List<Booking> findByBookingName(String bookingName);

}