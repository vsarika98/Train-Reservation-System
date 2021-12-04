package com.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	public List<Admin> findByAdminName(String bName); // generate a custom query
//	// select * from Bank where bankName=?1

}

