package com.capgemini.ttrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ttrms.model.Station;


@Repository
public interface StationRepository extends JpaRepository<Station, Integer>{

}
