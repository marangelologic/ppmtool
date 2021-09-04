package com.example.react.service;

import java.util.List;
import com.example.react.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.react.model.Project;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository repository;

    public List<Project> getAllProjects() {
       return repository.findAll();
    }

}
