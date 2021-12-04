package com.train.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.model.Booking;
import com.train.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;
	
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking); 	
	}
	public List<Booking> getAllBookings(){
		return bookingRepository.findAll();
	}
	
	public Optional<Booking> getBookingDetailsById(int bookingId) {
		return bookingRepository.findById(bookingId);
	}
	
	public void deleteBookingDetailsById(int bookingId) {
		bookingRepository.deleteById(bookingId);
	}
	
	public Booking updateBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
	 
//	public List<Booking> getAllBookingsByName(String bookingName){  // Query Generation
//		return bookingRepository.findByBookingName(bookingName);
//	}
}