package com.train.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.train.model.TrainRoute;

@Repository
public interface RouteRepository extends JpaRepository<TrainRoute,Integer> {
	public List<TrainRoute> findByRouteName(String rName); 
}
