package com.example.firstYearExamProject.Service;

import com.example.firstYearExamProject.Model.SessionTime;
import com.example.firstYearExamProject.Repository.SessionTimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    // Rasmus
    // Mathias

@Service
public class SessionTimeService {
    @Autowired
    SessionTimeRepo sessionTimeRepo;

    public List<SessionTime> fetchAllSessionTimes() {
        return sessionTimeRepo.fetchAllSessionTimes();
    }

    public boolean deleteSessionTime(String sessionTimeID) {
        return sessionTimeRepo.deleteSessionTime(sessionTimeID);
    }

    public SessionTime findSessionByID(int sessionTimeID) {
        return sessionTimeRepo.findSessionByID(sessionTimeID);
    }

    public SessionTime editSessionTime(int sessionTimeID, SessionTime sessionTime) {
        return sessionTimeRepo.editSessionTime(sessionTimeID, sessionTime);
    }

    public SessionTime createSessionTime(SessionTime sessionTime) {
        return sessionTimeRepo.createSessionTime(sessionTime);
    }

}


