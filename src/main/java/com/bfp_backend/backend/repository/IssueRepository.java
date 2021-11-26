package com.bfp_backend.backend.repository;

import com.bfp_backend.backend.model.Issue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    //Query for list of userId given project id
    @Query("SELECT i.user.userId FROM Issue i where i.project.projectId = :projectId")
    List<Long> findUserIdByProjectId(@Param("projectId") long id);
    
    //Query for number of issue given projectId and userId
    @Query("SELECT i.id FROM Issue i where i.project.projectId = :projectId and i.user.userId = :userId")
    List<Long> findIssuesByProjectandUserId(@Param("projectId") long id,@Param("userId") long id2);

    //Query for list of issues by projectId
    @Query("SELECT i.id FROM Issue i where i.project.projectId = :projectId")
    List<Long> findIssuesByProjectId(@Param("projectId") long id);

    @Query("SELECT i.id FROM Issue i where i.user.userId= :userId")
    List<Long> findIssuesByUserId(@Param("userId") long id);
}
