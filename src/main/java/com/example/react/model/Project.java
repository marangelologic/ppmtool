
package com.example.react.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Valid
    @NotNull(message = "project name cannot be null!")
    private String name;

    private String description;

}
