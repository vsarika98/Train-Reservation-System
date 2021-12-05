package com.train.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.model.TrainRoute;
import com.train.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepository  routeRepository;
	
	public TrainRoute createRoute(TrainRoute troute) {
		return routeRepository.save(troute); 
											
	}
	public List<TrainRoute> getAllRoute(){
		return routeRepository.findAll();
	}
	
	public Optional<TrainRoute> getRouteDetailsById(int routeId) {
	
		return routeRepository.findById(routeId);
	}
	
	public void deleteTrainRouteDetailsById(int routeId) {
		routeRepository.deleteById(routeId);
	}
	public TrainRoute updateCustomer1(TrainRoute troute) {
		return routeRepository.save(troute); // if the bsnkId already exists in the db merge									  // if the bankId is not there in db then persist
	}
	 
	public List<TrainRoute> getAllRouteByName(String routeName){  // Query Generation
		return routeRepository.findByRouteName(routeName);
	}

}
