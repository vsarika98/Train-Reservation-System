package com.trS.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trS.model.Station;

import antlr.collections.List;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer>{

	List findByStationName(String stationName);

	Optional<Station> findByTrainName(String trainName);

}
