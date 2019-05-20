package com.example.demo.Service;

import com.example.demo.Model.SessionTime;
import com.example.demo.Repository.SessionTimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SessionTimeService {
    @Autowired
    SessionTimeRepo sessionTimeRepo;

    public List<SessionTime> fetchAll(){
        return sessionTimeRepo.fetchAll();}

    public boolean deleteSessionTime(String sessionTimeID){
        return sessionTimeRepo.deleteSessionTime(sessionTimeID);
    }

    public SessionTime findSessionByID(int sessionTimeID){
        return sessionTimeRepo.findSessionByID(sessionTimeID);
    }

    public SessionTime updateSessionTime (int sessionTimeID, SessionTime sessionTime) {
        return sessionTimeRepo.updateSessionTime(sessionTimeID, sessionTime);
    }

    public SessionTime addSessionTime(SessionTime sessionTime){
        return sessionTimeRepo.addSessionTime(sessionTime);
    }

    public String getCurrentTimeUsingDate() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String localTime = dateFormat.format(date);
        return localTime;
    }
}


