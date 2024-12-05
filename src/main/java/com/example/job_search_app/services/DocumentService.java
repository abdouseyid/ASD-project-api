package com.example.job_search_app.services;

import com.example.job_search_app.dto.DocumentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DocumentService {
    List<DocumentDto> getAll();

    void insert(DocumentDto documentDto);

    void update(DocumentDto documentDto);

    void deleteById(Long id);

    DocumentDto getOne(Long id);
}
