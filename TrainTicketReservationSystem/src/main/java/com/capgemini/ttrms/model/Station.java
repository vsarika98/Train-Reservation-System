package com.capgemini.ttrms.model;

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
public class Station {
	@Id
	@GeneratedValue
	private int stationId;
	private String stationName; 
	private int trainNo;
	private String arrivalTime;
	private String hault;

	
}
