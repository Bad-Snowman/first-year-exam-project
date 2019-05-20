package com.example.demo.Repository;

import com.example.demo.Model.SessionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public class SessionTimeRepo {
    @Autowired
    JdbcTemplate template;


    //Handles sql statements
    public List<SessionTime> fetchAll(){
        String sql;

        sql = "SELECT * FROM sessionTime";

        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);

        return template.query(sql, rowMapper);
    }

    public SessionTime findSessionByID(int sessionTimeID){
        String sql = "SELECT * FROM sessionTime WHERE sessionTimeID = ?";
        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);
        SessionTime sessionTime = template.queryForObject(sql, rowMapper, sessionTimeID);
        return sessionTime;
    }

    public SessionTime updateSessionTime(int sessionTimeID, SessionTime sessionTime){
        String sql = "UPDATE sessionTime SET sessionTimeDate = ?, sessionTimeStart = ?, " +
                "sessionTimeEnd = ?, sessionTimeEmpID = ?, sessionTimeProID = ? WHERE sessionTimeID = ?";
        template.update(sql, sessionTime.getSessionTimeDate(), sessionTime.getSessionTimeStart(),
                sessionTime.getSessionTimeEnd(), sessionTime.getSessionTimeEmpID(),
                sessionTime.getSessionTimeProID(), sessionTime.getSessionTimeID());
        return null;
    }


    public boolean deleteSessionTime(String sessionTimeID) {
        String sql = "DELETE FROM sessionTime WHERE sessionTimeID=?";
        return template.update(sql, sessionTimeID) > 0;
    }

    public static void getCurrentTimeUsingDate() {
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
    }

    public SessionTime addSessionTime(SessionTime sessionTime) {
        String sql = "INSERT INTO sessionTime (sessionTimeDate, sessionTimeStart, sessionTimeEnd, sessionTimeEmpID, sessionTimeProID) VALUES(?, ?, ?, ?, ?)";
        template.update(sql, sessionTime.getSessionTimeDate(), sessionTime.getSessionTimeStart(), sessionTime.getSessionTimeEnd(), sessionTime.getSessionTimeEmpID(), sessionTime.getSessionTimeProID());
        return null;
    }
}
