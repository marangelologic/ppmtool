package com.example.react.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.react.model.Project;
import com.example.react.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@Validated
public class ProjectController {

    @Autowired
    ProjectService service;

    @GetMapping
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }

    @PostMapping("")
    public ResponseEntity<Project> createNewProject(@Valid @RequestBody Project project){
    
        return new ResponseEntity<Project>(service.createNewProject(project), HttpStatus.CREATED);
    }
}
