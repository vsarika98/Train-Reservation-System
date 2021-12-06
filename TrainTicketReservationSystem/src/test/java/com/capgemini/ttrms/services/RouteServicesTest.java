package com.capgemini.ttrms.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capgemini.ttrms.model.TrainRoute;
import com.capgemini.ttrms.repository.RouteRepository;

@SpringBootTest
public class RouteServicesTest {
	@Autowired
	private RouteServices rs;
	
	@MockBean
	private RouteRepository rr;
	
	@Test
	public void testGetAllTrainDetails(){
		TrainRoute train = new TrainRoute();
		train.setRouteId(01);
		train.setRouteName("Pune to Goa");
		train.setFirst_station("Pune");
		train.setLast_station("Goa");
		train.setTrain_name("Pune Express");
		train.setTrain_Time("2:45 PM");
	 	
		TrainRoute train1 = new TrainRoute();
		train1.setRouteId(04);
		train1.setRouteName("Surat to Bhusaval");
		train1.setFirst_station("Udhana");
		train1.setLast_station("Jalgaon");
		train1.setTrain_name("Passenger");
		train1.setTrain_Time("5:00 AM");
		
		List<TrainRoute> trainrouteDetails = new ArrayList<>();
		trainrouteDetails.add(train);
		trainrouteDetails.add(train1);
		
		Mockito.when(rr.findAll()).thenReturn(trainrouteDetails);
		
		assertThat(rs.getAllRoute()).isEqualTo(trainrouteDetails);
	}

}
