package com.example.react.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.react.model.Project;
import com.example.react.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService service;

    @GetMapping
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        
        if(result.hasErrors()) {
            Map<String, String> errorMessageMap = new HashMap<>();
            result.getFieldErrors().forEach(error-> errorMessageMap.put(error.getField(), error.getDefaultMessage()));

            return new ResponseEntity<Map<String,String>>(errorMessageMap, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Project>(service.createNewProject(project), HttpStatus.CREATED);
    }
}
