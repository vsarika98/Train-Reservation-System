package com.capgemini.ttrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ttrms.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	public List<Admin> findByAdminName(String bName); 

}
