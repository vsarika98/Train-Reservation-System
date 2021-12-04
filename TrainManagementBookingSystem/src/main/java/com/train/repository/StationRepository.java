package com.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.train.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer>{

}