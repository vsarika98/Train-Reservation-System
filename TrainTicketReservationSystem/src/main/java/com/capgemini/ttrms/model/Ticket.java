package com.capgemini.ttrms.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Ticket implements Serializable {
@Id
@GeneratedValue
private int ticketId;
private long pnrNumber;
private String customerName;
private String startLocation;
private String endLocation;
private String time;
private String trainName;
private int platformNo;
private double price;






}
