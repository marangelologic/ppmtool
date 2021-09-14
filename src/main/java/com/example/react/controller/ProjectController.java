package com.example.react.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.react.model.Project;
import com.example.react.service.MapValidationErrorMessageService;
import com.example.react.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService service;

    @Autowired
    MapValidationErrorMessageService mapValidationErrorMessageService;

    @GetMapping
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result) {

        ResponseEntity<?> errorMap = mapValidationErrorMessageService.MapValidationErrorMessageService(result);

        if (errorMap != null) {
            return errorMap;
        }

        return new ResponseEntity<Project>(service.createNewProject(project), HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@Valid @PathVariable String projectId){
        Project project = service.findProjectById(projectId);

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }
}
