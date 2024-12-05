package com.example.job_search_app.mapper;

import com.example.job_search_app.dto.UserDTO;
import com.example.job_search_app.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	UserDTO userTouserDto(User user);
	User toEntity(UserDTO userDTO);
}
