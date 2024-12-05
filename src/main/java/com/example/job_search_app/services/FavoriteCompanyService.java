package com.example.job_search_app.services;


import com.example.job_search_app.dto.favoriteCompaniesDTO;

import java.util.List;

public interface FavoriteCompanyService {
	List<favoriteCompaniesDTO> getAll();

	void insert(favoriteCompaniesDTO favoriteCompaniesDTO);

	void update(favoriteCompaniesDTO favoriteCompaniesDTO);

	void deleteById(Long id);

	favoriteCompaniesDTO getOne(Long id);

}
