package com.example.job_search_app.dto;

import com.example.job_search_app.entities.Role;

public record UserReqDTO(
        int id,
        String firstname,
        String lastname,
        String email,
        String jobTitle,
        String password,
        Role role
) {
}
