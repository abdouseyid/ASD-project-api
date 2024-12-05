package com.example.job_search_app.repositories;

import com.example.job_search_app.entities.FavoriteCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteCompanyRepository extends JpaRepository<FavoriteCompany, Long> {

}

