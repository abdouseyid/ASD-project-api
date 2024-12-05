package com.example.job_search_app.dto;

import com.example.job_search_app.entities.ApplicationStatus;
import com.example.job_search_app.entities.User;

import java.time.LocalDate;

public record ApplicationDTO(
        String title,
        String description,
        String companyInfo,
        String location,
        LocalDate date,
        ApplicationStatus progress
        ){
}