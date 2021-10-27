package com.bfp_backend.backend.repository;

import com.bfp_backend.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
