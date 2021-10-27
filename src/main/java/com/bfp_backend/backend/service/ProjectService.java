package com.bfp_backend.backend.service;

import java.util.List;

import com.bfp_backend.backend.model.Project;
import com.bfp_backend.backend.web.dto.ProjectDto;

public interface ProjectService  {
    
    Project save(ProjectDto projectDto);

    List<Project> getAllProjects ();

}
