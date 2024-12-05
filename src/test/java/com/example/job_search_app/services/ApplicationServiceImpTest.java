package com.example.job_search_app.services;

import com.example.job_search_app.entities.Application;
import com.example.job_search_app.mapper.ApplicationMapper;
import com.example.job_search_app.repositories.ApplicationRepository;
import com.example.job_search_app.services.implementation.ApplicationServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Random;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceImpTest {

    private ApplicationMapper mapper = ApplicationMapper.INSTANCE;
    private ApplicationServiceImp underTest;
    private AutoCloseable autoCloseable;

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private UserService userService;

    @Mock
    private Application application;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ApplicationServiceImp(applicationRepository, userService);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void getAll() {
        int userId = 1; // Example user ID
        underTest.getAll(userId);
        verify(applicationRepository).findApplicationsByUserId(userId);
    }

    @Test
    void getById() {
        Long applicationId = new Random().nextLong();
        when(applicationRepository.findById(applicationId)).thenReturn(Optional.of(application));
        underTest.getOne(applicationId);
        verify(applicationRepository).findById(applicationId);
    }

    @Test
    void create() {
        var applicationDto = mapper.applicationToApplicationDto(application);
        int userId = 1;
        underTest.insert(userId,applicationDto);
        verify(applicationRepository).save(any(Application.class));
    }

    @Test
    void deleteApplicationById() {
        Long id = new Random().nextLong();
        underTest.deleteApplicationById(id);
        verify(applicationRepository).deleteById(id);
    }
}
