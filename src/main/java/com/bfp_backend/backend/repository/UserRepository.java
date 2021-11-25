package com.bfp_backend.backend.repository;

import com.bfp_backend.backend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserEmail(String userEmail);
    
    @Query("SELECT u.userHandle FROM User u where u.userId = :userId")
    String findUserHandleById(@Param("userId") long id);
}
