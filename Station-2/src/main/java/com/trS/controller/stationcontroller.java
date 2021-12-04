package com.trS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
	return "Welcome first Spring boot project";
	}

	@RequestMapping(value="/station", method=RequestMethod.POST )
	public Station createStation(@Validated @RequestBody Station station) {
	return stationservice.createStation(station);
	}



}
