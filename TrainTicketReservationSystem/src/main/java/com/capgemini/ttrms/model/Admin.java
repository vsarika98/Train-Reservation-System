package com.capgemini.ttrms.model;

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
public class Admin implements Serializable {
	@Id
	@GeneratedValue
	private int adminId;
	
	
	private String adminName;
	
	
	private String password;
	 
}
