package com.capgemini.ttrms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ttrms.model.Admin;
import com.capgemini.ttrms.repository.AdminRepository;

@Service
public class AdminServices {
	@Autowired
	private AdminRepository adminRepository;

	public Admin createAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return  adminRepository.save(admin);
	}

	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	
	}

	public Optional<Admin> getAdminDetailsById(int bId) {
		// TODO Auto-generated method stub
		return adminRepository.findById(bId);
	}

	



	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminRepository.save(admin);
	}

	public void deleteAdminDetailsById(int bId) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(bId);
	}

	public List<Admin> getAdminByName(String aName) {
		// TODO Auto-generated method stub
		return adminRepository.findByAdminName(aName);
	}

	 
	public List<Admin> getAdminByPassword(String aPassword) {
		// TODO Auto-generated method stub
		return adminRepository.findByAdminName(aPassword);
	}


	 
	 
}
