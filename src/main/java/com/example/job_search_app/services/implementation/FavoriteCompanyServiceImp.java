package com.example.job_search_app.services.implementation;

import com.example.job_search_app.dto.favoriteCompaniesDTO;
import com.example.job_search_app.entities.FavoriteCompany;
import com.example.job_search_app.mapper.FavoriteCompanyMapper;
import com.example.job_search_app.repositories.FavoriteCompanyRepository;
import com.example.job_search_app.services.FavoriteCompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteCompanyServiceImp implements FavoriteCompanyService {
	private final FavoriteCompanyRepository favoriteCompanyRepository;
	private final FavoriteCompanyMapper Mapper = FavoriteCompanyMapper.INSTANCE;


	public FavoriteCompanyServiceImp(FavoriteCompanyRepository favoriteCompanyRepository) {
		this.favoriteCompanyRepository = favoriteCompanyRepository;
	}

	@Override
	public List<favoriteCompaniesDTO> getAll() {
		List<FavoriteCompany> favoriteCompanies = favoriteCompanyRepository.findAll();

		return favoriteCompanies.stream().map(Mapper::toFavoriteCompanyDTO).toList();
	}

	@Override
	public void insert(favoriteCompaniesDTO favoriteCompaniesDTO) {
		FavoriteCompany favoriteCompany = Mapper.toFavoriteCompany(favoriteCompaniesDTO);
		favoriteCompanyRepository.save(favoriteCompany);
	}

	@Override
	public void update(favoriteCompaniesDTO favoriteCompaniesDTO) {
		FavoriteCompany favoriteCompanies = Mapper.toFavoriteCompany(favoriteCompaniesDTO);
		favoriteCompanyRepository.save(favoriteCompanies);

	}

	@Override
	public void deleteById(Long id) {
		favoriteCompanyRepository.deleteById(id);
	}

	@Override
	public favoriteCompaniesDTO getOne(Long id) {
		FavoriteCompany favoriteCompany = favoriteCompanyRepository.findById(id).orElse(null);
		return Mapper.toFavoriteCompanyDTO(favoriteCompany);
	}
}
