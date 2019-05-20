package com.example.demo.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;
//
@Entity
public class SessionTime {

    @Id
    private int sessionTimeID;
    private String sessionTimeStart;
    private String sessionTimeEnd;
    private String SessionTimeDate;
    private int SessionTimeEmpID;
    private int sessionTimeProID;
    private String employeeLastName;


    private String projectName;

    public SessionTime(){};

    public SessionTime(int sessionTimeID, String sessionTimeStart, String sessionTimeEnd,
                       String sessionTimeDate, int sessionTimeEmpID, int sessionTimeProID,
                       String employeeLastName, String projectName) {

        this.sessionTimeID = sessionTimeID;
        this.sessionTimeStart = sessionTimeStart;
        this.sessionTimeEnd = sessionTimeEnd;
        SessionTimeDate = sessionTimeDate;
        SessionTimeEmpID = sessionTimeEmpID;
        this.sessionTimeProID = sessionTimeProID;
        this.employeeLastName = employeeLastName;
        this.projectName = projectName;
    }

    ////////////// Getters and Setters //////////////

    public int getSessionTimeID() {
        return sessionTimeID;
    }

    public void setSessionTimeID(int sessionTimeID) {
        this.sessionTimeID = sessionTimeID;
    }

    public String getSessionTimeStart() { return sessionTimeStart; }

    public void setSessionTimeStart(String sessionTimeStart) {
        this.sessionTimeStart = sessionTimeStart;
    }

    public String getSessionTimeEnd() {
        return sessionTimeEnd;
    }

    public void setSessionTimeEnd(String sessionTimeEnd) { this.sessionTimeEnd = sessionTimeEnd; }

    public String getSessionTimeDate() {
        return SessionTimeDate;
    }

    public void setSessionTimeDate(String sessionTimeDate) {
        SessionTimeDate = sessionTimeDate;
    }

    public int getSessionTimeEmpID() {
        return SessionTimeEmpID;
    }

    public void setSessionTimeEmpID(int sessionTimeEmpID) {
        SessionTimeEmpID = sessionTimeEmpID;
    }

    public int getSessionTimeProID() {
        return sessionTimeProID;
    }

    public void setSessionTimeProID(int sessionTimeProID) {
        this.sessionTimeProID = sessionTimeProID;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
