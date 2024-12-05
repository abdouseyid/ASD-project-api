package com.example.job_search_app.controllers;

import com.example.job_search_app.dto.InterviewDTO;
import com.example.job_search_app.services.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/interviews")
public class InterviewController {

    private final InterviewService interviewService;

    @GetMapping
    public List<InterviewDTO> getAll() {
        return interviewService.getAll();
    }

    @GetMapping("/{id}")
    public InterviewDTO getById(@PathVariable long id) {
        return interviewService.getOne(id);
    }

    @PostMapping
    public void insert(@RequestBody InterviewDTO interviewDTO) {
        interviewService.insert(interviewDTO);
    }

    @PutMapping
    public void update(@RequestBody InterviewDTO interviewDTO) {
        interviewService.update(interviewDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        interviewService.deleteById(id);
    }
}
