package com.capgemini.ttrms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ttrms.model.Train;
import com.capgemini.ttrms.repository.TrainRepository;

@Service
public class TrainServices {
	@Autowired
	private TrainRepository tr;
	
	public Train createTrain(Train train) {
		System.out.println("created..");
		return tr.save(train);
	}
	
	public Optional<Train> getTrainDetailsByTrainNo(int trainNo){
		return tr.findById(trainNo);
	}
	//get all train details
	public List<Train> getAllTrain(){
		return tr.findAll();
	}

	public Train updateTrain(Train train) {
		
		return tr.save(train);
	}
	public void deleteTrainDetailsByTrainNo(int trainNo) {
		tr.deleteById(trainNo);
	}
	
	public List<Train> getTrainDetailsByTrainName(String trainName){
		return tr.findByTrainName(trainName);
	}
	
	public List<Train> getTrainDetailsByStationName(String station){
		return tr.findByStation(station);
	}
	
	public List<Train> getTrainDetailsBySourceName(String source){
		return tr.findBySource(source);
	}

}
