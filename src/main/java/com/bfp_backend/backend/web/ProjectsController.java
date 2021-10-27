package com.bfp_backend.backend.web;

import java.util.List;

import com.bfp_backend.backend.model.Project;
import com.bfp_backend.backend.service.ProjectService;
import com.bfp_backend.backend.web.dto.ProjectDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectsController {
    
    private ProjectService projectService;

    public ProjectsController(ProjectService projectService)
    {
        this.projectService=projectService;
    }


    @PostMapping
    public String createProject(@ModelAttribute ProjectDto projectDto )
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
           return projectService.getAllProjects();
        } 
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    //get mehtod for individual project
    //edit individual projects
    //delete post
  
}
