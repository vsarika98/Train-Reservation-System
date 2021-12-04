package com.train.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.train.model.Station;
import com.train.service.StationService;

import antlr.collections.List;

@RestController
public class StationController {

	@Autowired
	private StationService stationservice;


	@RequestMapping(value = "/st", method = RequestMethod.GET)
	public String welcome() {
	return "Welcome to Station Module";
	}

	@RequestMapping(value="/station", method=RequestMethod.POST )
	public Station createStation(@Validated @RequestBody Station station) {
	return stationservice.createStation(station);
	}



}