package com.example.job_search_app.services.implementation;

import com.example.job_search_app.dto.DocumentDto;
import com.example.job_search_app.entities.Document;
import com.example.job_search_app.mapper.DocumentMapper;
import com.example.job_search_app.repositories.DocumentRepository;
import com.example.job_search_app.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper Mapper = DocumentMapper.INSTANCE;

    @Override
    public List<DocumentDto> getAll() {
        List<Document> Documents = documentRepository.findAll();
        return Documents.stream().map(Mapper::documentToDocumentDTO).toList();
    }

    @Override
    public void insert(DocumentDto DocumentDTO) {
        Document Document = Mapper.documentDtoToDocument(DocumentDTO);
        documentRepository.save(Document);
    }

    @Override
    public void update(DocumentDto DocumentDTO) {
        Document Document = Mapper.documentDtoToDocument(DocumentDTO);
        documentRepository.save(Document);
    }

    @Override
    public void deleteById(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public DocumentDto getOne(Long id) {
        Document Document = documentRepository.getOne(id);
        return Mapper.documentToDocumentDTO(Document);
    }
}
