package com.bfp_backend.backend.service;

import java.util.List;

import com.bfp_backend.backend.model.Project;
import com.bfp_backend.backend.repository.ProjectRepository;
import com.bfp_backend.backend.web.dto.ProjectDto;

import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    @Override
    public Project save(ProjectDto projectDto) {
        Project project = new Project(projectDto.getProjectTitle(),projectDto.getProjectDesc(),projectDto.getProjectFiles(),projectDto.getProjectDownloadNo());
        return projectRepository.save(project);
    }


    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
    
    
}
