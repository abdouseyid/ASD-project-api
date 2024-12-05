package com.example.job_search_app.repositories;

import com.example.job_search_app.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Long> {
    List<Application> findApplicationsByUserId(int id);
    Optional<Application> findApplicationByIdAndUserId(Long applicationId, int userId);
}