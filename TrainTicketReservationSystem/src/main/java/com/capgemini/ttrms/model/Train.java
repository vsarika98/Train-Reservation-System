package com.capgemini.ttrms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Train {
	@Id
	@Generated
	
	private int trainNo;
	@NotBlank(message = "train name not be null")
	private String trainName;
	private String trainDate;
	private String arrivalTime;
	private String departureTime;
	private int availableOfSeat;
	private String source;
	private String station;
	private int distance;
	
	
	
}
