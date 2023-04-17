package com.example.SWE645Assignment3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SWE645Assignment3.repository.*;

import com.example.SWE645Assignment3.repository.*;
import com.example.SWE645Assignment3.dto.*;
import java.util.*;

@Service
public class SurveyService{
	@Autowired
    private SurveyRepository surveyRepo;
	
	 public List<?> getSurveyData() {
			 System.out.println(surveyRepo.getSurveyData());
		        return surveyRepo.getSurveyData();
	    }
}
