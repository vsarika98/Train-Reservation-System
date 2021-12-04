package com.train.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.train.*;
import com.train.model.Admin;
import com.train.service.AdminService;
 
@RestController

public class AdminController {
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping(value = "/ad", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome first Spring boot project";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.POST )
	public Admin createAdmin(@Validated @RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET )
	public List<Admin> getAllAdmin() {
		return  adminService.getAllAdmin(); // List<Bank>
	}
	
	@RequestMapping(value="/admin/{adminId}", method=RequestMethod.GET )
	public Admin getAdminDetailsById(@PathVariable("adminId") int bId) {
		Optional<Admin> admin = adminService.getAdminDetailsById(bId);
		return admin.get();
		
	}
 
	
	
	@RequestMapping(value="/admin", method=RequestMethod.PUT )
	public Admin updateAdminDetails(@RequestBody Admin admin) {
		return  adminService.updateAdmin(admin);	
	}
	@RequestMapping(value="/admin/{adminId}", method=RequestMethod.DELETE)
	public String deleteAdminDetails(@PathVariable("adminId") int bId) {
		Optional<Admin> b = adminService.getAdminDetailsById(bId);
		if(b.isPresent()) {
			adminService.deleteAdminDetailsById(bId);
			return "The Admin Details deleted with the admin ID: "+bId;
		}
		
		return "The Admin Details Not deleted with the admin ID: "+bId;
		
	}
	
	@RequestMapping(value="/admin/adminname/{adminname}", method=RequestMethod.GET)
	public List<Admin> getAdminByName(@PathVariable("adminname") String aName){
		return adminService.getAdminByName(aName);
	}
}
