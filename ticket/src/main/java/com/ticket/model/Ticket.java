package com.ticket.model;




import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Ticket implements Serializable {
@Id
private int ticketId;
//@NotBlank(message = "Ticket Name cannot be null")
private String ticketName;


private String customerName;
private String startLocation;
private String endLocation;
private String time;
private String trainName;
private int platformNo;






}