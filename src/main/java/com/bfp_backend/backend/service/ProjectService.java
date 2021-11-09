package com.bfp_backend.backend.service;

import java.util.List;
import java.util.Set;

import com.bfp_backend.backend.model.Issue;
import com.bfp_backend.backend.model.Project;
import com.bfp_backend.backend.web.dto.IssueDto;
import com.bfp_backend.backend.web.dto.ProjectDto;
import com.bfp_backend.backend.web.dto.SolutionDto;

public interface ProjectService  {
    
    Project save(ProjectDto projectDto);

    List<Project> getAllProjects ();

    Project getProject(long id);

    void deleteProject(long id);

    void editProject(long id, ProjectDto projectDto);

    Set<Long> getProjectsByUserEmail(String email);

    Issue addIssue(long id, IssueDto issueDto);

    List<Issue> getIssues(long id);

    // void addSolution(long id, long id2, SolutionDto solutionDto);

}
