package com.example.demo.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

@Entity
public class Project {
    @Id
    private int projectID;
    private String projectName;
    private String projectDesc;
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Time projectExpectedTime;
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Time projectUsedTime;

    //123
    public Project(){}

    public Project(int projectID, String projectName, String projectDesc, Time projectExpectedTime, Time projectUsedTime){
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
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

    public Time getProjectExpectedTime(){
        return projectExpectedTime;
    }

    public void setProjectExpectedTime(Time projectExpectedTime){
        this.projectExpectedTime = projectExpectedTime;
    }

    public Time getProjectUsedTime(){
        return projectUsedTime;
    }

    public void setProjectUsedTime(Time projectUsedTime){
        this.projectUsedTime = projectUsedTime;
    }

}
