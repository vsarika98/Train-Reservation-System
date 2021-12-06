package com.capgemini.ttrms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ttrms.model.Train;


@Repository
public interface TrainRepository extends JpaRepository<Train, Integer>{
	public List<Train> findByTrainName(String tName);
	public List<Train> findByStation(String station);
	public List<Train> findBySource(String source);

}