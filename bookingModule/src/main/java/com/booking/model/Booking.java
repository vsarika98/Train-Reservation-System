package com.booking.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
//JSON Request
/*
 {
    "bookingId":0,
    "departureDate": "07/12/2021",
    "sourceStation": "pune",
    "returnDate":"10/12/2021",
    "destinationStation": "Jhansi",
    "numOfSeats":5,
    "passengerName":"Sarika",
    "price":500.00
}
 */