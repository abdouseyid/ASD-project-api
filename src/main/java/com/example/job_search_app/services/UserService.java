package com.example.job_search_app.services;

import com.example.job_search_app.dto.UserDTO;
import com.example.job_search_app.entities.ChangePasswordRequest;
import com.example.job_search_app.entities.User;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<UserDTO> getAll();
    void insert(UserDTO userdto);
    void updateUser(UserDTO userdto);
    void deleteUserById(Integer id);
    UserDTO findUserById(Integer id);
    void changePassword(ChangePasswordRequest changePasswordRequest, Principal connectedUser);
}
