package com.trS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trS.model.Station;
import com.trS.service.Stationservice;

import antlr.collections.List;

@RestController
public class stationcontroller {

	@Autowired
	private Stationservice stationservice;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome() {
	return "Welcome to Station Information Module";
	}

	@RequestMapping(value="/station", method=RequestMethod.POST )
	public Station createStation(@Validated @RequestBody Station station) {
	return stationservice.createStation(station);
	}
	
	//get all station details
		@RequestMapping(value="/station", method = RequestMethod.GET)
		public java.util.List<Station> getAllStation(){
			return stationservice.getAllStation();
		}
		
		//update stations
		@RequestMapping(value="/station", method=RequestMethod.PUT)
		public Station updateStationDetails(@RequestBody Station station) {
			return stationservice.updateStation(station);
		}
		
		//get station details by station name
		@RequestMapping(value="/station/stationName/{stationName}", method=RequestMethod.GET)
		public List getStationDetailsByStationName(@PathVariable("stationName") String stationName){
			return stationservice.getStationDetailsByStationName(stationName);
		}
		
	//get station details by train name
	@RequestMapping(value = "/station/{trainName}", method = RequestMethod.GET)
	public Station getStationDetailsByTrainName(@PathVariable("trainName")String trainName) {
		Optional<Station> station = stationservice.getStationDetailsByTrainName(trainName);
		return station.get();
	}
	

}
