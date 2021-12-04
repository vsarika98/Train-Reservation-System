package com.booking.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.model.Booking;
import com.booking.service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome to Booking module";
	}
	
	@RequestMapping(value="/booking", method=RequestMethod.POST )
	public Booking createBooking(@Valid @RequestBody Booking booking) {
		return bookingService.createBooking(booking);
	}
	
	@RequestMapping(value="/booking", method=RequestMethod.GET )
	public List<Booking> getAllBookings(){
		return bookingService.getAllBookings(); 
	}
	
	@RequestMapping(value="/booking/{bookingId}", method=RequestMethod.GET )
	public Booking getBookingDetailsById(@PathVariable("bookingId") int bId) {
		Optional<Booking> booking = bookingService.getBookingDetailsById(bId);
		return booking.get();
		
	}

	@RequestMapping(value="/booking", method=RequestMethod.PUT )
	public Booking updateBookingDetails(@RequestBody Booking booking) {
		return bookingService.updateBooking(booking);	
	}
	
	@RequestMapping(value="/booking/{bookingId}", method=RequestMethod.DELETE)
	public String deleteBookingDetails(@PathVariable("bookingId") int bId) {
		Optional<Booking> b = bookingService.getBookingDetailsById(bId);
		if(b.isPresent()) {
			bookingService.deleteBookingDetailsById(bId);
			return "The Booking Details deleted with the booking ID: "+bId;
		}
		
		return "The Booking Details Not deleted with the booking ID: "+bId;
		
	}
}
