package com.example.demo.Repository;

import com.example.demo.Model.SessionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository is a collection of useable sql statements.
@Repository
public class SessionTimeRepo {
    @Autowired
    JdbcTemplate template;


    //Handles sql statements
    public List<SessionTime> fetchAll() {
        String sql;
        //this statement is used to get the sessionTime list. We use the SELECT to choose the tables and values
        //this statement uses a inner join to get values from the three tables
        //sessionTime, employee, project. and orders the list by ascending.
        sql = "SELECT sessiontime.sessionTimeID, sessiontime.sessionTimeDate, sessiontime.sessionTimeStart,\n" +
                "sessiontime.sessionTimeEnd, sessiontime.sessionTimeEmpID, employee.employeeLastName, sessiontime.sessionTimeProID,\n" +
                "project.projectName\n" +
                "\n" +
                "FROM ((sessiontime\n" +
                "\n" +
                "INNER JOIN employee ON employee.employeeID = sessiontime.sessionTimeEmpID)\n" +
                "INNER JOIN project ON project.projectID = sessiontime.sessionTimeProID)\n" +
                "ORDER BY sessionTimeID ASC;";
        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);

        return template.query(sql, rowMapper);
    }

    // this method uses the SELECT *, FROM and WHERE keywords to find a session depending on the sessionTimeID chossen.
    //
    public SessionTime findSessionByID(int sessionTimeID) {
        String sql = "SELECT * FROM sessionTime WHERE sessionTimeID = ?";
        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);
        SessionTime sessionTime = template.queryForObject(sql, rowMapper, sessionTimeID);
        return sessionTime;
    }

    //
    public SessionTime findSessionByEmpID (int sessionTimeEmpID){
        String sql = "SELECT * FROM sessionTime WHERE sessionTimeEmpID = ?";
        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);
        SessionTime sessionTime = template.queryForObject(sql, rowMapper, sessionTimeEmpID);
        return sessionTime;
    }

    //
    public SessionTime updateSessionTime(int sessionTimeID, SessionTime sessionTime) {
        String sql = "UPDATE sessionTime SET sessionTimeDate = ?, sessionTimeStart = ?, " +
                "sessionTimeEnd = ?, sessionTimeEmpID = ?, sessionTimeProID = ? WHERE sessionTimeID = ?";
        template.update(sql, sessionTime.getSessionTimeDate(), sessionTime.getSessionTimeStart(),
                sessionTime.getSessionTimeEnd(), sessionTime.getSessionTimeEmpID(),
                sessionTime.getSessionTimeProID(), sessionTime.getSessionTimeID());
        return null;
    }

    //This statement deletes a session depending on which sessionTimeID is choosen.
    public boolean deleteSessionTime(String sessionTimeID) {
        String sql = "DELETE FROM sessionTime WHERE sessionTimeID=?";
        return template.update(sql, sessionTimeID) > 0;
    }

    //
    public SessionTime addSessionTime(SessionTime sessionTime) {
        String sql = "INSERT INTO sessionTime (sessionTimeDate, sessionTimeStart, sessionTimeEnd, " +
                "sessionTimeEmpID, sessionTimeProID) VALUES(?, ?, ?, ?, ?)";
        template.update(sql, sessionTime.getSessionTimeDate(), sessionTime.getSessionTimeStart(),
                sessionTime.getSessionTimeEnd(), sessionTime.getSessionTimeEmpID(),
                sessionTime.getSessionTimeProID());
        return null;
    }
}
