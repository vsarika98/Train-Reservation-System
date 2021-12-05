package com.train.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Admin.findByAdminName",query = "select a from Admin a where a.adminName=?1")
@NamedQuery(name = "Admin.findByPassword",query = "select a from Admin a where a.password=?1")
@NamedQuery(name = "Admin.findByPasswordAndAdminName",query = "select a from Admin a where a.password=?1 and a.adminName=?2")
public class Admin implements Serializable {
	@Id
	@GeneratedValue
	private int adminId;
	//@NotBlank(message = "Admin Name cannot be null")
	
	private String adminName;
	//@NotBlank(message = " Password cannot be empty")
	
	private String password;
	 
}