package com.example.demo.Model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class SessionTime {

    @Id
    private int sessionTimeID;
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Time sessionTimeStart;
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Time sessionTimeEnd;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date SessionTimeDate;

    private int SessionTimeEmpID;
    private int sessionTimeProID;

    public SessionTime(){};

    public SessionTime(int sessionTimeID, Time sessionTimeStart, Time sessionTimeEnd,
                       Date sessionTimeDate, int sessionTimeEmpID, int sessionTimeProID) {
        this.sessionTimeID = sessionTimeID;
        this.sessionTimeStart = sessionTimeStart;
        this.sessionTimeEnd = sessionTimeEnd;
        SessionTimeDate = sessionTimeDate;
        SessionTimeEmpID = sessionTimeEmpID;
        this.sessionTimeProID = sessionTimeProID;
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

    public Date getSessionTimeDate() {
        return SessionTimeDate;
    }

    public void setSessionTimeDate(Date sessionTimeDate) {
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
}
