package com.bfp_backend.backend.web;

import java.util.List;

import com.bfp_backend.backend.model.Project;
import com.bfp_backend.backend.service.ProjectService;
import com.bfp_backend.backend.web.dto.ProjectDto;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "localhost:3000")
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
    

  
}
