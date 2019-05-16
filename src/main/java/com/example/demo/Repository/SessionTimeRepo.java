package com.example.demo.Repository;

import com.example.demo.Model.SessionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SessionTimeRepo {
    @Autowired
    JdbcTemplate template;

    public List<SessionTime> fetchAll(){
        String sql;

        sql = "SELECT * FROM sessionTime";

        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);

        return template.query(sql, rowMapper);
    }

    public SessionTime getSessionTimeID(int sessionTimeID){
        String sql = "SELECT * FROM sessionTime WHERE sessionTimeID = ?";
        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);
        SessionTime sessionTime = template.queryForObject(sql, rowMapper, sessionTimeID);
        return sessionTime;
    }

    public SessionTime updateSessionTime(int sessionTimeID, SessionTime sessionTime){
        String sql = "UPDATE sessionTime SET sessionTime (sessionTimeID,sessionTimeDate, sessionTimeStart, sessionTimeEnd, sessionTimeEmpID, sessionTimeProID)" +
                "VALUES(?,?,?,?,?,?) WHERE sessionTimeID=?";
        template.update(sql, sessionTime.getSessionTimeID(), sessionTime.getSessionTimeDate(), sessionTime.getSessionTimeStart(),
                sessionTime.getSessionTimeEnd(), sessionTime.getSessionTimeEmpID(), sessionTime.getSessionTimeProID());
        return null;
    }

    public boolean deleteSessionTime(String sessionTimeID) {
        String sql = "DELETE FROM sessionTime WHERE sessionTimeID=?";
        return template.update(sql, sessionTimeID) > 0;
    }
//

}
