package com.bfp_backend.backend.web;

import java.util.List;
import java.util.Set;

import com.bfp_backend.backend.model.Issue;
import com.bfp_backend.backend.model.Project;
import com.bfp_backend.backend.model.Solution;
import com.bfp_backend.backend.service.ProjectService;
import com.bfp_backend.backend.web.dto.IssueDto;
import com.bfp_backend.backend.web.dto.ProjectDto;
import com.bfp_backend.backend.web.dto.SolutionDto;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectsController {
    
    private ProjectService projectService;

    public ProjectsController(ProjectService projectService)
    {
        this.projectService=projectService;
    }


    @PostMapping
    public String createProject(@RequestBody ProjectDto projectDto )
    {
        try {
            projectService.save(projectDto);
            return "success";
        } catch (Exception e) {
            System.out.println(e);
            return "failure";
        }
    }

    @GetMapping
    public List<Project> getProjects()
    {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
           return projectService.getAllProjects();
        } 
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //get mehtod for individual project
    @GetMapping("/{id}")
    public Project getProject(@PathVariable String id)
    
    {
        try {
            return projectService.getProject(Long.parseLong(id));
        } 
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    //patch method for edit individual projects
    @PatchMapping("/{id}")
    public String editProject(@PathVariable long id,@RequestBody ProjectDto projectDto)
    {
        try {
            projectService.editProject(id,projectDto);
            return "success";
        } 
        catch (Exception e) {
            System.out.println(e);
            return "failure";
        }
    }

    //delete method for deleting a project
    @DeleteMapping ("/{id}")
    public String deleteProject(@PathVariable long id)
    {
        try {
            projectService.deleteProject(id);
            return "success";
        } 
        catch (Exception e) {
            System.out.println(e);
            return "failure";
        }
    }

    //get all projects of a useremail
    @GetMapping("/user/{email}")
    public Set<Long> getProjectsByUserEmail(@PathVariable String email)
    {
        try {
            return projectService.getProjectsByUserEmail(email);
        } 
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @PostMapping("/{id}/issues")
    public String addIssue(@PathVariable long id,@RequestBody IssueDto issueDto)
    {
        try {
            projectService.addIssue(id,issueDto);
            return "success";
        } 
        catch (Exception e) {
            System.out.println(e);
            return "failure";
        }
    }
  
    //get all issues of a project
    @GetMapping("/{id}/issues")
    public List<Issue> getIssues(@PathVariable long id)
    {
        try {
            return projectService.getIssues(id);
        } 
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @PostMapping("/{id}/issues/{id2}/solutions")
    public String addIssue(@PathVariable long id,@RequestBody SolutionDto solutionDto)
    {
        try {
            projectService.addSolution(id,solutionDto);
            return "success";
        } 
        catch (Exception e) {
            System.out.println(e);
            return "failure";
        }
    }

    @GetMapping("/{id}/issues/{id2}/solutions")
    public List<Solution> getSolutions(@PathVariable long id)
    {
        try {
            return projectService.getSolutions(id);
        } 
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    // @PostMapping("/{id}/issues/{id2}/solutions")
    // public String addSolution(@PathVariable long id,@PathVariable long id2,@RequestBody SolutionDto solutionDto)
    // {
    //     try {
    //         projectService.addSolution(id,id2,solutionDto);
    //         return "success";
    //     } 
    //     catch (Exception e) {
    //         System.out.println(e);
    // }
    //     return "failure";
    // }
}
   
    




    

  

