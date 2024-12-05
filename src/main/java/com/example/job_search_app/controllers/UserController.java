package com.example.job_search_app.controllers;

import com.example.job_search_app.dto.UserDTO;
import com.example.job_search_app.entities.ChangePasswordRequest;
import com.example.job_search_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public List<UserDTO> getAll(){
        return userService.getAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable("id") Integer id) {
        UserDTO userDTO = userService.findUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }
   
    @PutMapping
    public void updateJob(@RequestBody UserDTO user){
        userService.updateUser(user);
    }
    @DeleteMapping("/{id}")
    public void deleteJobById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
    }

    @PatchMapping
    public ResponseEntity<?> changePassword(
          @RequestBody ChangePasswordRequest request,
          Principal connectedUser
    ) {
        userService.changePassword(request, connectedUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
