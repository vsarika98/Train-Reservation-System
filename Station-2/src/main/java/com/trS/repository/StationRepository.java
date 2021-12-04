package com.trS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trS.model.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, Integer>{

}
