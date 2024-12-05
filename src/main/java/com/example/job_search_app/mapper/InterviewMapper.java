package com.example.job_search_app.mapper;

import com.example.job_search_app.dto.InterviewDTO;
import com.example.job_search_app.entities.Interview;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InterviewMapper {
    InterviewMapper INSTANCE = Mappers.getMapper(InterviewMapper.class);
    InterviewDTO interviewToInterviewDTO(Interview interview);
    Interview interviewDtoToInterview(InterviewDTO interviewDTO);
}
