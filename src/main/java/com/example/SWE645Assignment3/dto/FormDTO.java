package com.example.SWE645Assignment3.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class FormDTO {
	// fields from Student class
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String telephoneNumber;
    private String email;
    
    // fields from Survey class
    private Date surveyDate;
    private String universityInterest;
    private String recommendation;
    
    private String comments;

    
    // fields from CampusLike class
    private List<String> Likes;
    private Boolean optionStudent;
    private Boolean optionLocation;
    private Boolean optionCampus;
    private Boolean optionAtmosphere;
    private Boolean optionDormRooms;
    private Boolean optionSports;
    
    // fields from Raffle class
    private String numbersEntered;
    private Boolean won;
}
