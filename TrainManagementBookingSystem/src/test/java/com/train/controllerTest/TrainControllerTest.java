package com.train.controllerTest;


//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.train.controller.ProjectController;
//import com.train.model.Train;
//import com.train.service.TrainService;
//


//@WebMvcTest(value=ProjectController.class)
public class TrainControllerTest {
//@Autowired
//private MockMvc mockMvc;
//
//@MockBean
//private TrainService ts;
//
//@Test
//public void testCreateTrain() throws Exception {
//
//Train train = new Train();
//train.setTrainNo(12345);
//train.setTrainName("Navjivan SF Express");
//train.setTrainDate("12-12-2021");
//train.setArrivalTime("09:00 AM");
//train.setDepartureTime("09:10 AM");
//train.setAvailableOfSeat(210);
//train.setSource("Dondaicha");
//train.setStation("Bhusaval");
//train.setDistance(150);
//
//String inputInJson = this.mapToJson(train);
//
//String URI = "/train";
//
//Mockito.when(ts.createTrain(Mockito.any(Train.class))).thenReturn(train);
//
//RequestBuilder requestBuilder = MockMvcRequestBuilders
//.post(URI)
//.accept(MediaType.APPLICATION_JSON_VALUE).content(inputInJson)
//.contentType(MediaType.APPLICATION_JSON_VALUE);
//
//
//
//MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//MockHttpServletResponse response = result.getResponse();
//
//String outputInJson = response.getContentAsString();
//
//assertThat(outputInJson).isEqualTo(inputInJson);
//assertEquals(HttpStatus.OK.value(), response.getStatus());
//}
//
//@Test
//public void testGetAllBookedTickets() throws Exception {
//
//
//
//Train train = new Train();
//train.setTrainNo(12345);
//train.setTrainName("Navjivan SF Express");
//train.setTrainDate("12-12-2021");
//train.setArrivalTime("09:00 AM");
//train.setDepartureTime("09:10 AM");
//train.setAvailableOfSeat(210);
//train.setSource("Dondaicha");
//train.setStation("Bhusaval");
//train.setDistance(150);
//
//Train train1 = new Train();
//train1.setTrainNo(1234);
//train1.setTrainName("Havda SF Express");
//train1.setTrainDate("13-12-2021");
//train1.setArrivalTime("09:30 AM");
//train1.setDepartureTime("09:40 AM");
//train1.setAvailableOfSeat(190);
//train1.setSource("Nandurbar");
//train1.setStation("Pune");
//train1.setDistance(500);
//
//List<Train> trainDetails = new ArrayList<>();
//trainDetails.add(train);
//trainDetails.add(train);
//
//Mockito.when(ts.getAllTrain()).thenReturn(trainDetails);
//
//String URI = "/train";
//RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//URI).accept(
//MediaType.APPLICATION_JSON);
//
//
//
//MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//
//
//String expectedJson = this.mapToJson(trainDetails);
//
//String outputInJson = result.getResponse().getContentAsString();
//assertThat(outputInJson).isEqualTo(expectedJson);
//}
//
//@Test
//public void testGetTrainDetailsByTrainName() throws Exception {
//
//
//
//List<Train> train = new ArrayList<Train>();
//
//when(ts.getTrainDetailsByTrainName(Mockito.anyString())).thenReturn(train);
//
//String URI = "/train/trainname/Navjivan SF Express";
//RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//URI).accept(
//MediaType.APPLICATION_JSON);
//
//
//
//MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//
//
//String expectedJson = this.mapToJson(train);
//
//String outputInJson = result.getResponse().getContentAsString();
//assertThat(outputInJson).isEqualTo(expectedJson);
//}
//
//
//
//private String mapToJson(List<Train> trainDetails) throws JsonProcessingException {
//// TODO Auto-generated method stub
//ObjectMapper objectMapper = new ObjectMapper();
//return objectMapper.writeValueAsString(trainDetails);
//}
//
//
//
//
//
//private String mapToJson(Train train) throws JsonProcessingException {
//// TODO Auto-generated method stub
//ObjectMapper objectMapper = new ObjectMapper();
//return objectMapper.writeValueAsString(train);
//}
//


}