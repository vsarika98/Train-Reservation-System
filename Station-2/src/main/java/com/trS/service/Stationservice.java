package com.trS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trS.model.Station;
import com.trS.repository.StationRepository;

import antlr.collections.List;
@Service
public class Stationservice {
	@Autowired
	private StationRepository stationRepository;
	
	public Station createStation(Station station) {
		return stationRepository.save(station);	
	}

	
}
