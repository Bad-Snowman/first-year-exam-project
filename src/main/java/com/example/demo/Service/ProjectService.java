package com.example.demo.Service;

import com.example.demo.Model.Project;
import com.example.demo.Repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    ProjectRepo projectRepo;

    public List<Project> fetchAll() {
        return projectRepo.fetchAll();
    }

    /* //Ikke muligt grundet fk og pk celler i sessions
    public boolean deleteProject(String projectID){
        return projectRepo.deleteProject(projectID);
    } */

    public Project addProject(Project project) {
        return projectRepo.addProject(project);
    }

    public Project findProjectById(int projectID) {
        return projectRepo.findProjectById(projectID);
    }

    public Project updateProject(int projectID, Project p) {
        return projectRepo.updateProject(projectID, p);
    }
}
