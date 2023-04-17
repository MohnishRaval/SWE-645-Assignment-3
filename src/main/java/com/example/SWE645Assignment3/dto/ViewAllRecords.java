package com.example.SWE645Assignment3.dto;
import java.util.*;

import lombok.Data;

@Data
public class ViewAllRecords {
	private String firstName;
    private String lastName;
    private Boolean won;
    private Date surveyDate;
    
    public ViewAllRecords(String firstName, String lastName, Boolean won, Date surveyDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.won = won;
        this.surveyDate = surveyDate;
    }
}
