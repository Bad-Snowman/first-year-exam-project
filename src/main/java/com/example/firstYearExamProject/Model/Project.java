package com.example.firstYearExamProject.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Project {

    // Oliver

    // Fields
    @Id
    private int projectID;

    private String projectName;
    private String projectDesc;
    private String projectManagerName;
    private String projectExpectedTime;
    private String projectUsedTime;
    private String projectDeadline;
    private String projectDone;

    // Constructors
    public Project() {
    }

    public Project(int projectID, String projectName, String projectDesc, String projectManagerName,
                   String projectExpectedTime, String projectUsedTime, String projectDeadline, String projectDone) {
        this.projectID = projectID;
        this.projectName = projectName;
        this.projectDesc = projectDesc;
        this.projectManagerName = projectManagerName;
        this.projectExpectedTime = projectExpectedTime;
        this.projectUsedTime = projectUsedTime;
        this.projectDeadline = projectDeadline;
        this.projectDone = projectDone;
    }


//////////// Getters and setters ////////////

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjectManagerName() {
        return projectManagerName;
    }

    public void setProjectManagerName(String projectManagerName) {
        this.projectManagerName = projectManagerName;
    }

    public String getProjectExpectedTime() {
        return projectExpectedTime;
    }

    public void setProjectExpectedTime(String projectExpectedTime) {
        this.projectExpectedTime = projectExpectedTime;
    }

    public String getProjectUsedTime() {
        return projectUsedTime;
    }

    public void setProjectUsedTime(String projectUsedTime) {
        this.projectUsedTime = projectUsedTime;
    }

    public String getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectDeadline(String projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public String getProjectDone() {
        return projectDone;
    }

    public void setProjectDone(String projectDone) {
        this.projectDone = projectDone;
    }
}
