package com.example.job_search_app.services.implementation;

import com.example.job_search_app.dto.UserDTO;
import com.example.job_search_app.entities.User;
import com.example.job_search_app.exceptions.UserNotFoundException;
import com.example.job_search_app.mapper.UserMapper;
import com.example.job_search_app.repositories.UserRepository;
import com.example.job_search_app.entities.ChangePasswordRequest;
import com.example.job_search_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserMapper Mapper = UserMapper.INSTANCE;


    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(Mapper::userTouserDto).toList();
    }

    @Override
    public void insert(UserDTO userdto) {
        User user = Mapper.toEntity(userdto);
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDTO userdto) {
        User user = Mapper.toEntity(userdto);

        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO findUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return Mapper.userTouserDto(user.get());
        }
        throw new UserNotFoundException("User with id: " + id +" not found");
    }

    @Override
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

//         check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
//         check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

//         update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

//         save the new password
        userRepository.save(user);
    }

}
