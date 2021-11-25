package com.bfp_backend.backend.repository;

import com.bfp_backend.backend.model.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    //Query for number of project done by userID
    @Query("SELECT p.id FROM Project p where p.user.userId = :userId")
    List<Long> findProjectsFromUserId(@Param("userId") long id);
}
