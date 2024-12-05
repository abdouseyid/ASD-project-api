package com.example.job_search_app.controllers;

import com.example.job_search_app.dto.favoriteCompaniesDTO;
import com.example.job_search_app.services.FavoriteCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/favoriteCompanies")
public class FavoriteCompanyController {
	private final FavoriteCompanyService favoriteCompanyService;

	@GetMapping
	public List<favoriteCompaniesDTO> getAll() {
		return favoriteCompanyService.getAll();
	}

	@PostMapping
	public void insert(@RequestBody favoriteCompaniesDTO favoriteCompaniesDTO) {
		favoriteCompanyService.insert(favoriteCompaniesDTO);
	}

	@PutMapping
	public void update(@RequestBody favoriteCompaniesDTO favoriteCompaniesDTO) {
		favoriteCompanyService.update(favoriteCompaniesDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		favoriteCompanyService.deleteById(id);
	}

	@GetMapping("/{id}")
	public favoriteCompaniesDTO getOne(@PathVariable Long id) {
		return favoriteCompanyService.getOne(id);
	}
}
