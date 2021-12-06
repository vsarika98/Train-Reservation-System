package com.capgemini.ttrms.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ttrms.exception.AdminNotFoundException;
import com.capgemini.ttrms.exception.BookingNotPresentException;
import com.capgemini.ttrms.exception.CustomerNotFoundException;
import com.capgemini.ttrms.exception.RouteNotFoundException;
import com.capgemini.ttrms.exception.TicketNotFoundException;
import com.capgemini.ttrms.exception.TrainNotFoundException;
import com.capgemini.ttrms.model.Admin;
import com.capgemini.ttrms.model.Booking;
import com.capgemini.ttrms.model.Customer;
import com.capgemini.ttrms.model.Station;
import com.capgemini.ttrms.model.Ticket;
import com.capgemini.ttrms.model.Train;
import com.capgemini.ttrms.model.TrainRoute;
import com.capgemini.ttrms.services.AdminServices;
import com.capgemini.ttrms.services.BookingServices;
import com.capgemini.ttrms.services.CustomerServices;
import com.capgemini.ttrms.services.RouteServices;
import com.capgemini.ttrms.services.StationServices;
import com.capgemini.ttrms.services.TicketService;
import com.capgemini.ttrms.services.TrainServices;

@RestController
public class TrainTicketSystemController {

	Logger logger=LoggerFactory.getLogger(TrainTicketSystemController.class);
	
	@Autowired
	private AdminServices adminService;
	@Autowired
	private TrainServices ts;
	@Autowired
	private StationServices stationservice;
	@Autowired
	private CustomerServices customerService;
	@Autowired
	private BookingServices bookingService;
	@Autowired
	private RouteServices routeService;
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("Home method accessed");
		return "Welcome to Train Ticket Reservation System.";
	}
	
	//************Mappings for Admin Module************	
	@RequestMapping(value="/admin", method=RequestMethod.POST )
	public Admin createAdmin(@Validated @RequestBody Admin admin) {
		logger.info("Admin Details Created");
		return adminService.createAdmin(admin);
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET )
	public List<Admin> getAllAdmin() {
		logger.info("Admin Details Extracted");
		return  adminService.getAllAdmin(); // List<Bank>
	}
	
	@RequestMapping(value="/admin/{adminId}", method=RequestMethod.GET )
	public Admin getAdminDetailsById(@PathVariable("adminId") int bId) throws AdminNotFoundException {
		logger.info("Admin details extracted using admin id");
		Optional<Admin> admin = adminService.getAdminDetailsById(bId);
		if(admin.isPresent()) {
		return admin.get();
		}
		else {
			throw new AdminNotFoundException("Admin with given id is not present");
		}
		
	}
 
	@RequestMapping(value="/admin", method=RequestMethod.PUT )
	public Admin updateAdminDetails(@RequestBody Admin admin) {
		logger.info("Admin details updated");
		return  adminService.updateAdmin(admin);	
	}
	@RequestMapping(value="/admin/{adminId}", method=RequestMethod.DELETE)
	public String deleteAdminDetails(@PathVariable("adminId") int bId) {
		Optional<Admin> b = adminService.getAdminDetailsById(bId);
		if(b.isPresent()) {
			logger.info("Admin details deleted");
			adminService.deleteAdminDetailsById(bId);
			return "The Admin Details deleted with the admin ID: "+bId;
		}
		
		return "The Admin Details Not deleted with the admin ID: "+bId;
		
	}
	
	@RequestMapping(value="/admin/adminname/{adminname}", method=RequestMethod.GET)
	public List<Admin> getAdminByName(@PathVariable("adminname") String aName){
		logger.info("Admin details extracted using admin name");
		return adminService.getAdminByName(aName);
	}
	
	//Mappings for Customer module
	@RequestMapping(value="/customer", method=RequestMethod.POST )
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		logger.info("Customer details created");
		return customerService.createCustomer(customer);
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.GET )
	public List<Customer> getAllCustomers() {
		logger.info("All Customer details extracted");
		return customerService.getAllCustomer(); // List<Bank>
	}
	
	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.GET )
	public Customer getCustomerDetailsById(@PathVariable("customerId") int cId) throws CustomerNotFoundException{
		logger.info("Customer details extracted using customer id");
		Optional<Customer> customer = customerService.getCustomerDetailsById(cId);
		if(customer.isPresent()) {
		return customer.get();
		}
		else {
			throw new CustomerNotFoundException("Admin with given id is not present");
		}
		
	}

	@RequestMapping(value="/customer/gender/{gender}", method=RequestMethod.GET )
	public List<Customer> getCustomerDetailsByGender(@PathVariable("gender") String gender) {
		logger.info("Customer  details extracted using gender");
		return customerService.getCustomerDetailsByGender(gender);
		
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.PUT )
	public Customer updateCustomerDetails(@RequestBody Customer customer) {
		logger.info("Customer details updated");
		return customerService.updateCustomer(customer);	
	}
		
	@RequestMapping(value="/customer/{customerId}", method=RequestMethod.DELETE)
	public String deleteCustomerDetails(@PathVariable("customerId") int cId){
		logger.info("Customer details deleted");
		Optional<Customer> c = customerService.getCustomerDetailsById(cId);
		if(c.isPresent()) {
			customerService.deleteCustomerDetailsById(cId);
			return "The Customer Details deleted with the customer ID: "+cId;
		}
		
		return "The Customer Details Not deleted with the customer ID: "+cId;
		
	}
	//******************Train Module**********
	//Mappings for Train Module
	@RequestMapping(value="/train", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Train createTrain(@Valid @RequestBody Train train) {
		logger.info("Train details extracted");
		return ts.createTrain(train);
	}
	//get train details by train number
	@RequestMapping(value = "/train/{trainNo}", method = RequestMethod.GET)
	public Train getTrainDetailsByTrainNo(@PathVariable("trainNo")int tNo) throws TrainNotFoundException{
		logger.info("Train details extracted using train number");
		Optional<Train> train = ts.getTrainDetailsByTrainNo(tNo);
		if(train.isPresent()) {
		return train.get();
		}
		else {
			throw new TrainNotFoundException("Train with given id is not present");
		}
	}
	
	//get all train details
	@RequestMapping(value="/train", method = RequestMethod.GET)
	public List<Train> getAllTrain(){
		logger.info("All Train details extracted");
		return ts.getAllTrain();
	}
	
	//update train schedule
	@RequestMapping(value="/train", method=RequestMethod.PUT)
	public Train updateTrainDetails(@RequestBody Train train) {
		logger.info("Train details updated");
		return ts.updateTrain(train);
	}
	
	//delete train schedule by train number
	@RequestMapping(value="/train/{trainNo}", method=RequestMethod.DELETE)
	public String deleteBankDetails(@PathVariable("trainNo") int tNo) {
		logger.info("Train details deleted");
		Optional<Train> train = ts.getTrainDetailsByTrainNo(tNo);
		if(train.isPresent()) {
			ts.deleteTrainDetailsByTrainNo(tNo);
			return "The Train Schedule deleted with the Train Number: "+tNo;
		}
		
		return "The Train Schedule Not deleted with the train number: "+tNo;
	}
	
	@RequestMapping(value="/train/trainname/{trainname}", method=RequestMethod.GET)
	public List<Train> getTrainDetailsByTrainName(@PathVariable("trainname") String trainName){
		logger.info("Train details extracted using train name");
		return ts.getTrainDetailsByTrainName(trainName);
	}
	
	@RequestMapping(value="/train/station/{station}", method=RequestMethod.GET)
	public List<Train> getTrainDetailsByStationName(@PathVariable("station") String station){
		logger.info("Train details extracted using station name");
		return ts.getTrainDetailsByStationName(station);
	}
	
	@RequestMapping(value="/train/source/{source}", method=RequestMethod.GET)
	public List<Train> getTrainDetailsBySourceName(@PathVariable("source") String source){
		logger.info("Train details extracted using source station name");
		return ts.getTrainDetailsBySourceName(source);
	}
	
	//************Mappings for Booking Module****************	
	@RequestMapping(value="/booking", method=RequestMethod.POST )
	public Booking createBooking(@Valid @RequestBody Booking booking) {
		logger.info("Booking created");
		return bookingService.createBooking(booking);
	}
	
	@RequestMapping(value="/booking", method=RequestMethod.GET )
	public List<Booking> getAllBookings(){
		logger.info("All Booking details extracted");
		return bookingService.getAllBookings(); 
	}
	
	@RequestMapping(value="/booking/{bookingId}", method=RequestMethod.GET )
	public Booking getBookingDetailsById(@PathVariable("bookingId") int bId) throws BookingNotPresentException {
		Optional<Booking> booking = bookingService.getBookingDetailsById(bId);
		if(booking.isPresent()) {
			logger.info("Booking details extracted using booking id");
		return booking.get();
		}
		else {
			logger.info("Exception occured in booking details exctraction by the given id");
			throw new BookingNotPresentException("Booking details not present with the given booking id.");
		}
	}

	@RequestMapping(value="/booking", method=RequestMethod.PUT )
	public Booking updateBookingDetails(@RequestBody Booking booking) {
		logger.info("Booking details updated");
		return bookingService.updateBooking(booking);	
	}
	
	@RequestMapping(value="/booking/{bookingId}", method=RequestMethod.DELETE)
	public String deleteBookingDetails(@PathVariable("bookingId") int bId) {
		logger.info("Booking details delete method");
		Optional<Booking> b = bookingService.getBookingDetailsById(bId);
		if(b.isPresent()) {
			bookingService.deleteBookingDetailsById(bId);
			return "The Booking Details deleted with the booking ID: "+bId;
		}
		
		return "The Booking Details Not deleted with the booking ID: "+bId;		
	}
	
	//*************Mappings for Station Module******************
	@RequestMapping(value="/station", method=RequestMethod.POST )
	public Station createStation(@Validated @RequestBody Station station) {
	return stationservice.createStation(station);
	}
	
	//****************Mappings for Route Module***************
	@RequestMapping(value="/route", method=RequestMethod.POST)
	public TrainRoute createRoute(@RequestBody TrainRoute troute) {
		logger.info("Create route details method invoked.");
		return routeService.createRoute(troute);
	}
	
	
	@RequestMapping(value="/route", method=RequestMethod.GET )
	public List<TrainRoute> getAllRoutes() {
		logger.info("Get all route details method invoked.");
		return  routeService.getAllRoute(); 
	}
	
	@RequestMapping(value="/route/{routeId}", method=RequestMethod.GET )
	public TrainRoute getRouteDetailsById(@PathVariable("routeId") int rId) throws RouteNotFoundException{
		logger.info("Get route details by id method invoked.");
		Optional<TrainRoute> troute = routeService.getRouteDetailsById(rId);
		if(troute.isPresent()) {
	    return troute.get();}
		else {
			throw new RouteNotFoundException("Route with given id is not present");
		}				
	}
	
	@RequestMapping(value="/route", method=RequestMethod.PUT )
	public TrainRoute updateRouteDetails(@RequestBody TrainRoute troute) {
		logger.info("Update route detail method invoked.");
		return routeService.createRoute (troute);	
	}
	@RequestMapping(value="/route/{routeId}", method=RequestMethod.DELETE)
	public String deleteRouteDetails(@PathVariable("routeId") int rId) {
		Optional<TrainRoute> r = routeService.getRouteDetailsById(rId);
		if(r.isPresent()) {
		logger.info("Route detail delete method invoked.");
		routeService.deleteTrainRouteDetailsById(rId);
		
						return "The route Details deleted with the route ID: "+rId;
		}
		
		return "The route Details Not deleted with the route ID: "+rId;
		
	}
	
	//****************Mappings for Ticket Module*************
	@RequestMapping(value="/ticket", method=RequestMethod.POST )
	public Ticket createTicket(@RequestBody Ticket ticket) {
	logger.info("Create Ticket details method invoked.");
	return ticketService.createTicket(ticket);
	}

	@RequestMapping(value="/ticket", method=RequestMethod.GET )
	public List<Ticket> getAllTicket() {
		logger.info("Get all Ticket details method invoked.");
	return ticketService.getAllTicket();
	}

	@RequestMapping(value="/ticket/{ticketId}", method=RequestMethod.GET )
	public Ticket getTicketDetailsById(@PathVariable("ticketId") int cId) throws TicketNotFoundException{
	Optional<Ticket> ticket = ticketService.getTicketDetailsById(cId);
	if(ticket.isPresent()) {
		logger.info("Ticket details extracted using ticket id.");
		return ticket.get();
	}
	else {
		logger.info("Ticket not found exception occured");
		throw new TicketNotFoundException("Ticket with given ticket id is not present.");
	}
	}

	@RequestMapping(value="/ticket", method=RequestMethod.PUT )
	public Ticket updateTicketDetails(@RequestBody Ticket ticket) {
	return ticketService.createTicket(ticket);
	}
	
	@RequestMapping(value="/ticket/{ticketId}", method=RequestMethod.DELETE)
	public String deleteTicketDetails(@PathVariable("ticketId") int cId) {
	Optional<Ticket> c = ticketService.getTicketDetailsById(cId);
	if(c.isPresent()) {
		logger.info("Ticket detail delete method invoked.");
		ticketService.deleteTicketDetailsById(cId);
	return "The Ticket Details deleted with the ticket ID: "+cId;
	}

	return "The Ticket Details Not deleted with the ticket ID: "+cId;

	}
}
