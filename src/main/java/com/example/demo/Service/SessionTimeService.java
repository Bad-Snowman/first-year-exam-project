package com.example.demo.Service;

import com.example.demo.Model.SessionTime;
import com.example.demo.Repository.SessionTimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}


