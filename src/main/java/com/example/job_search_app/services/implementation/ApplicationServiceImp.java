package com.example.job_search_app.services.implementation;

import com.example.job_search_app.dto.ApplicationDTO;
import com.example.job_search_app.dto.UserDTO;
import com.example.job_search_app.entities.Application;
import com.example.job_search_app.entities.User;
import com.example.job_search_app.mapper.ApplicationMapper;
import com.example.job_search_app.mapper.UserMapper;
import com.example.job_search_app.repositories.ApplicationRepository;
import com.example.job_search_app.services.ApplicationService;
import com.example.job_search_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImp implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper Mapper = ApplicationMapper.INSTANCE;
    private final UserService userService;
    private final UserMapper userMapper = UserMapper.INSTANCE;


    @Override
    public List<ApplicationDTO> getAll(int id) {
        List<Application> applications = applicationRepository.findApplicationsByUserId(id);
        return applications.stream().map(Mapper::applicationToApplicationDto).toList();
    }

    @Override
    public void insert(int id,ApplicationDTO applicationDTO) {
        UserDTO userDTO = userService.findUserById(id);
        Application application = Mapper.applicationDtotoApplication(applicationDTO);
        User user = userMapper.toEntity(userDTO);
        application.setUser(user);
        applicationRepository.save(application);
    }

    @Override
    public void updateApplication(int userId,Long id, ApplicationDTO applicationDTO) {
        Optional<Application> application = applicationRepository.findApplicationByIdAndUserId(id,userId);
        if(application.isPresent()) {
            Application application1 = application.get();
            application1.setTitle(applicationDTO.title());
            application1.setDescription(applicationDTO.description());
            application1.setCompanyInfo(applicationDTO.companyInfo());
            application1.setLocation(applicationDTO.location());
            application1.setDate(applicationDTO.date());
            application1.setProgress(applicationDTO.progress());
            applicationRepository.save(application1);
        }
//        Application application = Mapper.applicationDtotoApplication(applicationDTO);
//        applicationRepository.save(application);
    }

    @Override
    public void deleteApplicationById(Long id) {
        applicationRepository.deleteById(id);
    }

    @Override
    public ApplicationDTO getOne(Long id) {
        Application application = applicationRepository.findById(id).orElse(null);
        return Mapper.applicationToApplicationDto(application);
    }
}
