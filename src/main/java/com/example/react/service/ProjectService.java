package com.example.react.service;

import java.util.List;

import com.example.react.exceptions.ProjectExceptionResponse;
import com.example.react.model.Project;
import com.example.react.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository repository;


    public List<Project> getAllProjects() {
       return repository.findAll();
    }

    public Project createNewProject(Project project){
        try {
            return repository.save(project);
        } catch (Exception e) {
            throw new ProjectExceptionResponse(e.getMessage() + project.getId());
        }
    }

}
