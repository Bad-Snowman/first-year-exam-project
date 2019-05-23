package com.example.demo.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

@Entity
public class Project {
    @Id

    // Fields
    private int projectID;
    private String projectName;
    private String projectDesc;
    private String projectManagerName;
    private double projectExpectedTime;
    private double projectUsedTime;

    // Constructors
    public Project(){}


    public Project(int projectID, String projectName, String projectDesc,
                   String projectManagerName, double projectExpectedTime, double projectUsedTime){
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.projectManagerName = projectManagerName;
        this.projectExpectedTime = projectExpectedTime;
        this.projectUsedTime = projectUsedTime;
    }


    //////////// Getters and setters ////////////

    public int getProjectID(){
        return projectID;
    }

    public void setProjectID(int projectID){
        this.projectID = projectID;
    }

    public String getProjectName(){
        return projectName;
    }

    public void setProjectName(String projectName){
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjectManagerName(){
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName){
        this.projectManagerName = projectManagerName;
    }

    public double getProjectExpectedTime(){
        return projectExpectedTime;
    }

    public void setProjectExpectedTime(double projectExpectedTime){
        this.projectExpectedTime = projectExpectedTime;
    }

    public double getProjectUsedTime(){
        return projectUsedTime;
    }

    public void setProjectUsedTime(double projectUsedTime){
        this.projectUsedTime = projectUsedTime;
    }

}
