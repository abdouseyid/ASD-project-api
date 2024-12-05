package com.example.job_search_app.controllers;

import com.example.job_search_app.dto.DocumentDto;
import com.example.job_search_app.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/documents")
public class DocumentController {
    private final DocumentService documentService;

    @GetMapping
    public List<DocumentDto> getAllDocuments() {
        return documentService.getAll();
    }

    @GetMapping("/{id}")
    public DocumentDto getDocumentById(@PathVariable long id) {
        return documentService.getOne(id);
    }

    @PostMapping
    public void addDocument(@RequestBody DocumentDto documentDto) {
        documentService.insert(documentDto);
    }
    
    @PutMapping
    public void updateDocument(@RequestBody DocumentDto documentDto) {
        documentService.update(documentDto);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable long id) {
        documentService.deleteById(id);
    }
}
