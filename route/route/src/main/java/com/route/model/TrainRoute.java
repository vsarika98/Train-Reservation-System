package com.route.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TrainRoute  implements Serializable{
	@Id
	@GeneratedValue
	private int routeId;
	@NotBlank(message="route Name cannot be null")
	private String routeName;
	private String first_station;
	private String last_station;
	private String train_name;
	private String train_Time;

}
