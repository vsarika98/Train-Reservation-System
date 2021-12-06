package com.capgemini.ttrms.model;

import java.io.Serializable;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer implements Serializable {
	@Id
	@GeneratedValue
	private int customerId;
	@NotBlank(message = "Customer Name cannot be null")
	private String customerName;
	@NotBlank(message = "Password is at least 4 digit")
	private String password;
	private String confirmPassword;
	private String gender;
	
	private String phone;
	//@NotNull
	//@Size(min = 1, max = 100)
	//@Pattern(regexp="^([a-zA-Z0-9\\-\\.\\_]+)'+'(\\@)([a-zA-Z0-9\\-\\.]+)'+'(\\.)([a-zA-Z]{2,4})$")
	@NotBlank(message = "email cannot be empty")
	private String email;
	private String dob;
}