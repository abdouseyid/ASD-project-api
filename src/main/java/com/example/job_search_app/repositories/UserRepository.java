package com.example.job_search_app.repositories;

import com.example.job_search_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findUserByEmail(String email);
}
