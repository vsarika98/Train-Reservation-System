package com.route.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.route.model.TrainRoute;

import com.route.service.RouteService;





@RestController
public class RouteController {
	@Autowired
	private RouteService routeService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
		return "Welcome first Spring boot project";
	}
	
	@RequestMapping(value="/route", method=RequestMethod.POST)
	public TrainRoute createRoute(@RequestBody TrainRoute troute) {
		return routeService.createRoute(troute);
	}
	
	//@RequestMapping(value="/route", method=RequestMethod.POST )
	//public TrainRoute createTrainRoute(@RequestBody TrainRoute troute) {
	//	return routeService.createRoute(troute);
	//}
	
	@RequestMapping(value="/route", method=RequestMethod.GET )
	public List<TrainRoute> getAllRoutes() {
		return  routeService.getAllRoute(); 
	}
	
	@RequestMapping(value="/route/{routeId}", method=RequestMethod.GET )
	public TrainRoute getRouteDetailsById(@PathVariable("routeId") int rId) {
		Optional<TrainRoute> troute = routeService.getRouteDetailsById(rId);
	return troute.get();
		
	}
	
	@RequestMapping(value="/route", method=RequestMethod.PUT )
	public TrainRoute updateRouteDetails(@RequestBody TrainRoute troute) {
		return routeService.createRoute (troute);	
	}
	@RequestMapping(value="/route/{routeId}", method=RequestMethod.DELETE)
	public String deleteRouteDetails(@PathVariable("routeId") int rId) {
		Optional<TrainRoute> r = routeService.getRouteDetailsById(rId);
		if(r.isPresent()) {
		routeService.deleteTrainRouteDetailsById(rId);
		
						return "The route Details deleted with the route ID: "+rId;
		}
		
		return "The route Details Not deleted with the route ID: "+rId;
		
	}
}



