package com.trS.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.trS.model.Station;
import com.trS.repository.StationRepository;

@SpringBootTest

public class Station2ServiceTest {

	@Autowired
	private Stationservice ss;
	
	@MockBean
	private StationRepository sr;
	
	@Test
	//@Ignore
	public void testCreateTrain(){

		Station station = new Station();
	 	station.setTrainNo(12345);
		station.setTrainName("Navjivan SF Express");
		station.setArrivalTime("09:00 AM");
		station.setDepartureTime("09:10 AM");
		station.setStationName("Nagpur");
		station.setStationId(1);
		station.setHault("Platform 3");
		
	    Mockito.when(sr.save(station)).thenReturn(station);
	    
	    assertThat(ss.createStation(station)).isEqualTo(station);
	
	}
	
//	@Test
//	public void testGetTrainDetailsByTrainNo(){
//		Optional<Station> station = Optional.of(new Station());
//	 	station.get();
//		
//	    Mockito.when(sr.findById(12345)).thenReturn(station);
//	    assertThat(ss.getStationDetailsByStationId(1)).isEqualTo(station);
//	}
	
	@Test
	public void testGetAllTrainDetails(){
		Station station = new Station();
	 	station.setTrainNo(12);
		station.setTrainName("Navjivan SF Express");
		station.setArrivalTime("09:00 AM");
		station.setDepartureTime("09:10 AM");
		station.setStationName("Nagpur");
		station.setStationId(1);
		station.setHault("Platform 3");
		
		Station station1 = new Station();
	 	station1.setTrainNo(13);
		station1.setTrainName("Shatabdi Express");
		station1.setArrivalTime("10:00 AM");
		station1.setDepartureTime("10:20 AM");
		station1.setStationName("Gondia");
		station1.setStationId(2);
		station.setHault("Platform 4");
		
		List<Station> stationDetails = new ArrayList<>();
		stationDetails.add(station);
		stationDetails.add(station);
		
		Mockito.when(sr.findAll()).thenReturn(stationDetails);
		
		assertThat(ss.getAllStation()).isEqualTo(stationDetails);
	}
	
	 @Test
	    public void customer_exists_in_db_success() {
		 	Station station = new Station();
		 	station.setTrainNo(12345);
			station.setTrainName("Navjivan SF Express");
			station.setArrivalTime("09:00 AM");
			station.setDepartureTime("09:10 AM");
			station.setStationName("Nagpur");
			station.setStationId(1);
			List<Station> stationDetails = new ArrayList<>();
			stationDetails.add(station);
			
			when(sr.findAll()).thenReturn(stationDetails);
			
			List<Station> getStation = ss.getAllStation();
			assertThat(getStation.size()).isGreaterThan(0);
	    }
}
	

