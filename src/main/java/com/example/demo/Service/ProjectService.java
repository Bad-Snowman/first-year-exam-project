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

    public List<Project> fetchAll(){
        return projectRepo.fetchAll();
    }

    /*public Project addProject(Project p){
        return projectRepo.addProject(p);
    }

    public Project findProjectById(int projectID){
        return projectRepo.findProjectById(projectID);
    }

    public Boolean deleteProject(int projectID){
        return projectRepo.deleteProject(projectID);
    }

    public Project updateProject(int projectID, Project p){
        return projectRepo.updateProject(projectID, p);
    }*/
}
