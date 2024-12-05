package com.example.job_search_app.mapper;

import com.example.job_search_app.dto.favoriteCompaniesDTO;
import com.example.job_search_app.entities.FavoriteCompany;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FavoriteCompanyMapper {
	FavoriteCompanyMapper INSTANCE = Mappers.getMapper(FavoriteCompanyMapper.class);

	favoriteCompaniesDTO toFavoriteCompanyDTO(FavoriteCompany favoriteCompany);

	FavoriteCompany toFavoriteCompany(favoriteCompaniesDTO favoriteCompaniesDTO);
}
