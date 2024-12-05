package com.example.job_search_app.services;

import com.example.job_search_app.dto.InterviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InterviewService {
    List<InterviewDTO> getAll();

    void insert(InterviewDTO interviewDTO);

    void update(InterviewDTO interviewDTO);

    void deleteById(Long id);

    InterviewDTO getOne(Long id);
}
