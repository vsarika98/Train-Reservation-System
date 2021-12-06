package com.capgemini.ttrms.services;

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

import com.capgemini.ttrms.model.Train;
import com.capgemini.ttrms.repository.TrainRepository;


@SpringBootTest
public class TrainServicesTest {
	

	@Autowired
	private TrainServices ts;
	
	@MockBean
	private TrainRepository tr;
	
	@Test
	//@Ignore
	public void testCreateTrain(){

		Train train = new Train();
	 	train.setTrainNo(12345);
		train.setTrainName("Navjivan SF Express");
		train.setTrainDate("12-12-2021");
		train.setArrivalTime("09:00 AM");
		train.setDepartureTime("09:10 AM");
		train.setAvailableOfSeat(210);
		train.setSource("Dondaicha");
		train.setStation("Bhusaval");
		train.setDistance(150);
		
	    Mockito.when(tr.save(train)).thenReturn(train);
	    
	    assertThat(ts.createTrain(train)).isEqualTo(train);
	
	}
	
	@Test
	public void testGetTrainDetailsByTrainNo(){
		Optional<Train> train = Optional.of(new Train());
	 	train.get();
		
	    Mockito.when(tr.findById(12345)).thenReturn(train);
	    assertThat(ts.getTrainDetailsByTrainNo(12345)).isEqualTo(train);
	}
	
	@Test
	public void testGetAllTrainDetails(){
		Train train = new Train();
	 	train.setTrainNo(12345);
		train.setTrainName("Navjivan SF Express");
		train.setTrainDate("12-12-2021");
		train.setArrivalTime("09:00 AM");
		train.setDepartureTime("09:10 AM");
		train.setAvailableOfSeat(210);
		train.setSource("Dondaicha");
		train.setStation("Bhusaval");
		train.setDistance(150);
		
		Train train1 = new Train();
	 	train1.setTrainNo(1234);
		train1.setTrainName("Havda SF Express");
		train1.setTrainDate("13-12-2021");
		train1.setArrivalTime("09:30 AM");
		train1.setDepartureTime("09:40 AM");
		train1.setAvailableOfSeat(190);
		train1.setSource("Nandurbar");
		train1.setStation("Pune");
		train1.setDistance(500);
		
		List<Train> trainDetails = new ArrayList<>();
		trainDetails.add(train);
		trainDetails.add(train);
		
		Mockito.when(tr.findAll()).thenReturn(trainDetails);
		
		assertThat(ts.getAllTrain()).isEqualTo(trainDetails);
	}
	
	 @Test
	    public void customer_exists_in_db_success() {
		 	Train train = new Train();
		 	train.setTrainNo(12345);
			train.setTrainName("Navjivan SF Express");
			train.setTrainDate("12-12-2021");
			train.setArrivalTime("09:00 AM");
			train.setDepartureTime("09:10 AM");
			train.setAvailableOfSeat(210);
			train.setSource("Dondaicha");
			train.setStation("Bhusaval");
			train.setDistance(150);
			List<Train> trainDetails = new ArrayList<>();
			trainDetails.add(train);
			
			when(tr.findAll()).thenReturn(trainDetails);
			
			List<Train> getTrain = ts.getAllTrain();
			assertThat(getTrain.size()).isGreaterThan(0);
	    }
}