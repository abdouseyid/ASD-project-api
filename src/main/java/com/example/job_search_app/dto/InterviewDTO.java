package com.example.job_search_app.dto;

import com.example.job_search_app.entities.InterviewStatus;

public record InterviewDTO(
        String date,
        String time,
        String location,
        InterviewStatus status
) {
}
