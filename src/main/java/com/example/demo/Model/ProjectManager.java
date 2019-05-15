package com.example.demo.Model;

public class ProjectManager extends Employee {

private int projectManagerID;
private boolean projectManagerAccess;
private String projectManagerWorksOn;
private int projectManagerEmpId;


    public ProjectManager(){


    };

    public ProjectManager(int projectManagerID, boolean projectManagerAccess, String projectManagerWorksOn, int projectManagerEmpId) {
        this.projectManagerID = projectManagerID;
        this.projectManagerAccess = projectManagerAccess;
        this.projectManagerWorksOn = projectManagerWorksOn;
        this.projectManagerEmpId = projectManagerEmpId;
    }


    //////////Generated getters and setters//////////


    public int getProjectManagerID() {
        return projectManagerID;
    }

    public void setProjectManagerID(int projectManagerID) {
        this.projectManagerID = projectManagerID;
    }

    public boolean isProjectManagerAccess() {
        return projectManagerAccess;
    }

    public void setProjectManagerAccess(boolean projectManagerAccess) {
        this.projectManagerAccess = projectManagerAccess;
    }

    public String getProjectManagerWorksOn() {
        return projectManagerWorksOn;
    }

    public void setProjectManagerWorksOn(String projectManagerWorksOn) {
        this.projectManagerWorksOn = projectManagerWorksOn;
    }

    public int getProjectManagerEmpId() {
        return projectManagerEmpId;
    }

    public void setProjectManagerEmpId(int projectManagerEmpId) {
        this.projectManagerEmpId = projectManagerEmpId;
    }
}


