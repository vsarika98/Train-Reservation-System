package com.capgemini.ttrms.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.ttrms.model.Station;
import com.capgemini.ttrms.repository.StationRepository;

@SpringBootTest
public class StationServicesTest {
	@Autowired
	private StationServices ss;
	
	@MockBean
	private StationRepository sr;
	
	@Test
	//@Ignore
	public void testCreateTrain(){

		Station station = new Station();
	 	station.setStationId(5);
	 	station.setStationName("JalGaon Junction");
	 	station.setTrainNo(19013);
	 	station.setArrivalTime("10:15 AM");
	 	station.setHault("Amalner");
	    Mockito.when(sr.save(station)).thenReturn(station);
	    
	    assertThat(ss.createStation(station)).isEqualTo(station);
	
	}
}
