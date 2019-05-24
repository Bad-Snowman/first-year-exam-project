package com.example.demo.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//
@Entity
public class SessionTime {

    @Id
    // Fields
    private int sessionTimeID;
    private Time sessionTimeStart;
    private Time sessionTimeEnd;
    private String SessionTimeDate;
    private int SessionTimeEmpID;
    private int sessionTimeProID;
    private String employeeLastName;
    private String employeeFirstName;
    private String projectName;


    // Constructors
    public SessionTime() {
    }

    public SessionTime(int sessionTimeID, Time sessionTimeStart, Time sessionTimeEnd, String sessionTimeDate,
                       int sessionTimeEmpID, int sessionTimeProID, String employeeLastName, String employeeFirstName, String projectName) {
        this.sessionTimeID = sessionTimeID;
        this.sessionTimeStart = sessionTimeStart;
        this.sessionTimeEnd = sessionTimeEnd;
        SessionTimeDate = sessionTimeDate;
        SessionTimeEmpID = sessionTimeEmpID;
        this.sessionTimeProID = sessionTimeProID;
        this.employeeLastName = employeeLastName;
        this.employeeFirstName = employeeFirstName;
        this.projectName = projectName;
    }


////////////// Getters and Setters //////////////


    public int getSessionTimeID() {
        return sessionTimeID;
    }

    public void setSessionTimeID(int sessionTimeID) {
        this.sessionTimeID = sessionTimeID;
    }

    public Time getSessionTimeStart() {
        return sessionTimeStart;
    }

    public void setSessionTimeStart(Time sessionTimeStart) {
        this.sessionTimeStart = sessionTimeStart;
    }

    public Time getSessionTimeEnd() {
        return sessionTimeEnd;
    }

    public void setSessionTimeEnd(Time sessionTimeEnd) {
        this.sessionTimeEnd = sessionTimeEnd;
    }

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

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

}
