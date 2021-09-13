package com.example.react.model.exception;

public class ProjectException {
    
    private String response;

    public ProjectException(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
