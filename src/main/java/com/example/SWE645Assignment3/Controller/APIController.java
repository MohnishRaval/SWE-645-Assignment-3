package com.example.SWE645Assignment3.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import com.example.SWE645Assignment3.dto.*;
import com.example.SWE645Assignment3.model.*;
import com.example.SWE645Assignment3.repository.*;
import com.example.SWE645Assignment3.service.SurveyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class APIController {
	@Autowired
	private StudentRepository studentrepo;
	
	@Autowired
	private RaffleRepository rafflerepo;
	
	@Autowired
	private CampusLikingRepository campuslikerepo;
	
	@Autowired
	private SurveyRepository surveyrepo;
	
	@Autowired
	private SurveyService surveyservice;
	
	
	@GetMapping(path="form/viewAllRecords", produces = "application/json")
	public List<?> getSurveyData() {
	    System.out.println(surveyservice.getSurveyData().getClass());
	    return surveyservice.getSurveyData();
	}


	@PostMapping("/form/submit")
	public ResponseEntity<?> submitForm(@RequestBody FormDTO formDTO) {
	    // map fields from FormDTO to Student entity
		System.out.println(formDTO);
	    Student student = new Student();
	    student.setFirstName(formDTO.getFirstName());
	    student.setLastName(formDTO.getLastName());
	    student.setAddress(formDTO.getStreetAddress());
	    student.setCity(formDTO.getCity());
	    student.setState(formDTO.getState());
	    student.setZipCode(formDTO.getZip());
	    student.setPhoneNumber(formDTO.getTelephoneNumber());
	    student.setEmail(formDTO.getEmail());
	    studentrepo.save(student);
	    
	    // map fields from FormDTO to Survey entity
	    Survey survey = new Survey();
	    survey.setUniversityInterest(formDTO.getUniversityInterest());
	    survey.setDate(formDTO.getSurveyDate());
	    survey.setRecommendation(formDTO.getRecommendation());
	    survey.setStudent(student);
	    surveyrepo.save(survey);
	    
	    // map fields from FormDTO to CampusLike entity
	    CampusLike campusLike = new CampusLike();
	    for(String opt:formDTO.getLikes())
	    {
	    	switch(opt) {
	    	case "optionStudent":
	    		campusLike.setOptionStudent(true);
	    		break;
	    	case "optionLocation":
	    		campusLike.setOptionLocation(true);
	    		break;
	    	case "optionCampus":
	    		campusLike.setOptionCampus(true);
	    		break;
	    	case "optionAtmosphere":
	    		campusLike.setOptionAtmosphere(true);
	    		break;
	    	case "optionDormRooms":
	    		campusLike.setOptionDormRooms(true);
	    		break;
	    	case "optionSports":
	    		campusLike.setOptionSports(true);
	    		break;
	    	}
	    }
	    campusLike.setSurvey(survey);
	    campuslikerepo.save(campusLike);

	    // map fields from FormDTO to Raffle entity
	    Raffle raffle = new Raffle();
	    raffle.setNumbersEntered(formDTO.getNumbersEntered());
	    raffle.setWon(formDTO.getWon());
	    raffle.setStudent(student);
	    rafflerepo.save(raffle);
	    
	    return ResponseEntity.ok().build();
	}
}
