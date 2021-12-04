package com.capgemini.ttrs.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ttrs.model.Train;
import com.capgemini.ttrs.services.TrainServices;


@RestController
public class TrainController {
	@Autowired
	private TrainServices ts;
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Train Controller";
	}
	
	@RequestMapping(value="/train", method = RequestMethod.POST)
	public Train createTrain(@Valid @RequestBody Train train) {
		System.out.println("getiing data");
		return ts.createTrain(train);
	}
	//get train details by train number
	@RequestMapping(value = "/train/{trainNo}", method = RequestMethod.GET)
	public Train getTrainDetailsByTrainNo(@PathVariable("trainNo")int tNo) {
		Optional<Train> train = ts.getTrainDetailsByTrainNo(tNo);
		return train.get();
	}
	
	//get all train details
	@RequestMapping(value="/train", method = RequestMethod.GET)
	public List<Train> getAllTrain(){
		return ts.getAllTrain();
	}
	
	//update train schedule
	@RequestMapping(value="/train", method=RequestMethod.PUT)
	public Train updateTrainDetails(@RequestBody Train train) {
		return ts.updateTrain(train);
	}
	
	//delete train schedule by train number
	@RequestMapping(value="/train/{trainNo}", method=RequestMethod.DELETE)
	public String deleteBankDetails(@PathVariable("trainNo") int tNo) {
		Optional<Train> train = ts.getTrainDetailsByTrainNo(tNo);
		if(train.isPresent()) {
			ts.deleteTrainDetailsByTrainNo(tNo);
			return "The Train Schedule deleted with the Train Number: "+tNo;
		}
		
		return "The Train Schedule Not deleted with the train number: "+tNo;
	}
	
	@RequestMapping(value="/train/trainname/{trainname}", method=RequestMethod.GET)
	public List<Train> getTrainDetailsByTrainName(@PathVariable("trainname") String trainName){
		return ts.getTrainDetailsByTrainName(trainName);
	}
	
	@RequestMapping(value="/train/station/{station}", method=RequestMethod.GET)
	public List<Train> getTrainDetailsByStationName(@PathVariable("station") String station){
		return ts.getTrainDetailsByStationName(station);
	}
	
	@RequestMapping(value="/train/source/{source}", method=RequestMethod.GET)
	public List<Train> getTrainDetailsBySourceName(@PathVariable("source") String source){
		return ts.getTrainDetailsBySourceName(source);
	}
	
}
