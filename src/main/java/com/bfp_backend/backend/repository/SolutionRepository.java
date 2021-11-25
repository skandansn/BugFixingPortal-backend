package com.bfp_backend.backend.repository;

import com.bfp_backend.backend.model.Solution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface SolutionRepository extends JpaRepository<Solution, Long> {

    @Query("SELECT s.user.userId FROM Solution s where s.issue.issueId = :issueId")
    List<Long> findUserIdByIssueId(@Param("issueId") long id);
    
    @Query("SELECT s.id FROM Solution s where s.issue.issueId = :issueId and s.user.userId = :userId")
    List<Long> findSolutionsByIssueandUserId(@Param("issueId") long id,@Param("userId") long id2);

    @Query("SELECT s.id FROM Solution s where s.issue.issueId = :issueId")
    List<Long> findSolutionsByIssueId(@Param("issueId") long id);
}
