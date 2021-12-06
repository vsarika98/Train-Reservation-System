package com.capgemini.ttrms.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking implements Serializable{

	@Id
	@GeneratedValue
	private int bookingId;
	
	private String departureDate;
	private String sourceStation;
	private String returnDate;
	private String destinationStation;
	private int numOfSeats;
	private String passengerName;
	private double price;
	
}
