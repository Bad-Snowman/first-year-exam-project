package com.example.demo.Service;

import com.example.demo.Model.SessionTime;
import com.example.demo.Repository.SessionTimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionTimeService {
    @Autowired
    SessionTimeRepo SessionTimeRepo;

    public List<SessionTime> fetchAll(){return SessionTimeRepo.fetchAll();}

    public boolean deleteSessionTime(String sessionTimeID){
        return SessionTimeRepo.deleteSessionTime(sessionTimeID);
    }

    public SessionTime getSessionTimeID(int sessionTimeID){
        return SessionTimeRepo.getSessionTimeID(sessionTimeID);
    }

    public SessionTime updateSessionTime (int sessionTimeID, SessionTime sessionTime)
    {return SessionTimeRepo.updateSessionTime(sessionTimeID,sessionTime);}


}


