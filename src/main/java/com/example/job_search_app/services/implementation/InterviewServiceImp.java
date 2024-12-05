package com.example.job_search_app.services.implementation;

import com.example.job_search_app.dto.InterviewDTO;
import com.example.job_search_app.entities.Interview;
import com.example.job_search_app.mapper.InterviewMapper;
import com.example.job_search_app.repositories.InterviewRepository;
import com.example.job_search_app.services.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewServiceImp implements InterviewService {
    private final InterviewRepository interviewRepository;
    private final InterviewMapper Mapper = InterviewMapper.INSTANCE;

    @Override
    public List<InterviewDTO> getAll() {
        List<Interview> interviews = interviewRepository.findAll();
        return interviews.stream().map(Mapper::interviewToInterviewDTO).toList();
    }

    @Override
    public void insert(InterviewDTO interviewDTO) {
        Interview interview = Mapper.interviewDtoToInterview(interviewDTO);
        interviewRepository.save(interview);
    }

    @Override
    public void update(InterviewDTO interviewDTO) {
        Interview interview = Mapper.interviewDtoToInterview(interviewDTO);
        interviewRepository.save(interview);
    }

    @Override
    public void deleteById(Long id) {
        interviewRepository.deleteById(id);
    }

    @Override
    public InterviewDTO getOne(Long id) {
        Interview interview = interviewRepository.getOne(id);
        return Mapper.interviewToInterviewDTO(interview);
    }
}
