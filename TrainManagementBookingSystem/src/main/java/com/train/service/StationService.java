package com.train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.train.model.Station;
import com.train.repository.StationRepository;

import antlr.collections.List;
@Service
public class StationService {
	@Autowired
	private StationRepository stationRepository;
	
	public Station createStation(Station station) {
		return stationRepository.save(station);	
	}

	
}