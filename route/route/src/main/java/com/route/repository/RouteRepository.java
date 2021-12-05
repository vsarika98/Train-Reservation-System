package com.route.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.route.model.TrainRoute;
@Repository
public interface RouteRepository extends JpaRepository<TrainRoute, Integer>{
	
	
	List<TrainRoute> findByRouteName(String rName); 
	
	
	
}

