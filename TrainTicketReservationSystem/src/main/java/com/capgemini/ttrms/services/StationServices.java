package com.capgemini.ttrms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ttrms.model.Station;
import com.capgemini.ttrms.repository.StationRepository;
@Service
public class StationServices {
	@Autowired
	private StationRepository stationRepository;
	
	public Station createStation(Station station) {
		return stationRepository.save(station);	
	}

	
}
