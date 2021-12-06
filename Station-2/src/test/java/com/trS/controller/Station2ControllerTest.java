package com.trS.controller;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.trS.model.Station;
import com.trS.service.Stationservice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value=Station2ControllerTest.class)
public class Station2ControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private Stationservice ss;
	
	@Test
	public void testCreateStation() throws Exception {
		
		Station station = new Station();
	 	station.setTrainNo(12345);
		station.setTrainName("Navjivan SF Express");
		station.setArrivalTime("09:00 AM");
		station.setDepartureTime("09:10 AM");
		station.setStationName("Nagpur");
		station.setStationId(1);
		station.setHault("Platform 3");
		
		String inputInJson = this.mapToJson(station);
		
		String URI = "/station";
		
		Mockito.when(ss.createStation(Mockito.any(Station.class))).thenReturn(station);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON_VALUE).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		String outputInJson = response.getContentAsString();
		
//		assertThat(outputInJson).isEqualTo(inputInJson);
//		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
//	@Test
//	public void testGetAllStation() throws Exception {
//
//		Station station = new Station();
//	 	station.setTrainNo(12345);
//		station.setTrainName("Navjivan SF Express");
//		station.setArrivalTime("09:00 AM");
//		station.setDepartureTime("09:10 AM");
//		station.setStationName("Nagpur");
//		station.setStationId(1);
//		station.setHault("Platform 3");
//		
//		Station station1 = new Station();
//	 	station1.setTrainNo(13);
//		station1.setTrainName("Shatabdi Express");
//		station1.setArrivalTime("10:00 AM");
//		station1.setDepartureTime("10:20 AM");
//		station1.setStationName("Gondia");
//		station1.setStationId(2);
//		station.setHault("Platform 4");
//		
//		List<Station> stationDetails = new ArrayList<>();
//		stationDetails.add(station);
//		stationDetails.add(station);
//		
//		Mockito.when(ss.getAllStation()).thenReturn(stationDetails);
//		
//		String URI = "/station";
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				URI).accept(
//				MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		String expectedJson = this.mapToJson(stationDetails);
//		
//		String outputInJson = result.getResponse().getContentAsString();
//		assertThat(outputInJson).isEqualTo(expectedJson);
//	}
	
//	@Test
//	public void testGetStationDetailsByStationName() throws Exception {
//
//		List<Station> station = new ArrayList<Station>();
//		
//		when(ss.getStationDetailsByStationName(Mockito.anyString())).thenReturn(station);
//
//		
//		String URI = "/station/stationname/Nagpur";
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				URI).accept(
//				MediaType.APPLICATION_JSON);
//
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		String expectedJson = this.mapToJson(station);
//		
//		String outputInJson = result.getResponse().getContentAsString();
//		assertThat(outputInJson).isEqualTo(expectedJson);
//	}
	

	private String mapToJson(List<Station> stationDetails) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(stationDetails);
	}



	private String mapToJson(Station station) throws JsonProcessingException {
		// TODO Auto-generated method stub
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(station);
	}


}
