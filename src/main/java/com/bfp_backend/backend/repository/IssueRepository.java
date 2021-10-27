package com.bfp_backend.backend.repository;

import com.bfp_backend.backend.model.Issue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    
}
