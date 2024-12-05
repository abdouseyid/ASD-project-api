package com.example.job_search_app.mapper;

import com.example.job_search_app.dto.DocumentDto;
import com.example.job_search_app.entities.Document;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapper {
    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);
    DocumentDto documentToDocumentDTO(Document document);
    Document documentDtoToDocument(DocumentDto documentDto);
}
