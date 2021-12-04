package com.train.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

 

 

@Entity
@NamedQuery(name = "Admin.findByAdminName",query = "select a from Admin a where a.adminName=?1")
@NamedQuery(name = "Admin.findByPassword",query = "select a from Admin a where a.password=?1")
@NamedQuery(name = "Admin.findByPasswordAndAdminName",query = "select a from Admin a where a.password=?1 and a.adminName=?2")
public class Admin implements Serializable {
	@Id
	private int adminId;
	//@NotBlank(message = "Admin Name cannot be null")
	
	private String adminName;
	//@NotBlank(message = " Password cannot be empty")
	
	private String password;
	 
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminId, String adminName, String password) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
	
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String password() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
	

}