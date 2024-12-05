package com.example.job_search_app.mapper;

import com.example.job_search_app.dto.ApplicationDTO;
import com.example.job_search_app.entities.Application;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface ApplicationMapper {
	ApplicationMapper INSTANCE = Mappers.getMapper( ApplicationMapper.class );
	ApplicationDTO applicationToApplicationDto(Application application);
	Application applicationDtotoApplication(ApplicationDTO applicationDTO);
}