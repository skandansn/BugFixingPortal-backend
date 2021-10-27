package com.bfp_backend.backend.repository;

import com.bfp_backend.backend.model.Solution;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution, Long> {
    
}
