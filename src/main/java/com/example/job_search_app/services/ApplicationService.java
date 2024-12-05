package com.example.job_search_app.services;

import com.example.job_search_app.dto.ApplicationDTO;
import com.example.job_search_app.entities.Application;

import java.util.List;
import java.util.Optional;

public interface ApplicationService {
    List<ApplicationDTO> getAll(int id);
    void insert(int id , ApplicationDTO application);
    void updateApplication(int userId, Long id, ApplicationDTO application);
    void deleteApplicationById(Long id);
    ApplicationDTO getOne(Long id);
}
