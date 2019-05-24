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

    //Handles sql statements
    public List<SessionTime> fetchAll() {
        String sql;

        sql = "SELECT sessiontime.sessionTimeID, sessiontime.sessionTimeDate, sessiontime.sessionTimeStart,\n" +
                "sessiontime.sessionTimeEnd, sessiontime.sessionTimeEmpID, employee.employeeFirstName,\n" +
                "employee.employeeLastName, sessiontime.sessionTimeProID, project.projectName\n" +
                "\n" +
                "FROM ((sessiontime\n" +
                "\n" +
                "INNER JOIN employee ON employee.employeeID = sessiontime.sessionTimeEmpID)\n" +
                "INNER JOIN project ON project.projectID = sessiontime.sessionTimeProID)\n" +
                "ORDER BY sessionTimeID ASC;";

        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);

        return template.query(sql, rowMapper);
    }

    public SessionTime findSessionByID(int sessionTimeID) {
        String sql = "SELECT * FROM sessionTime WHERE sessionTimeID = ?";
        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);
        SessionTime sessionTime = template.queryForObject(sql, rowMapper, sessionTimeID);
        return sessionTime;
    }

    public boolean deleteSessionTime(String sessionTimeID) {
        String sql = "DELETE FROM sessionTime WHERE sessionTimeID=?";
        return template.update(sql, sessionTimeID) > 0;
    }

    public SessionTime createSessionTime(SessionTime sessionTime) {
        String sql = "INSERT INTO sessionTime (sessionTimeDate, sessionTimeStart, sessionTimeEnd, " +
                "sessionTimeEmpID, sessionTimeProID) VALUES(?, ?, ?, ?, ?)";
        template.update(sql, sessionTime.getSessionTimeDate(), sessionTime.getSessionTimeStart(),
                sessionTime.getSessionTimeEnd(), sessionTime.getSessionTimeEmpID(),
                sessionTime.getSessionTimeProID());
        return null;
    }

    public SessionTime editSessionTime(int sessionTimeID, SessionTime sessionTime) {
        String sql = "UPDATE sessionTime SET sessionTimeDate = ?, sessionTimeStart = ?, " +
                "sessionTimeEnd = ?, sessionTimeEmpID = ?, sessionTimeProID = ? WHERE sessionTimeID = ?";
        template.update(sql, sessionTime.getSessionTimeDate(), sessionTime.getSessionTimeStart(),
                sessionTime.getSessionTimeEnd(), sessionTime.getSessionTimeEmpID(),
                sessionTime.getSessionTimeProID(), sessionTime.getSessionTimeID());
        return null;
    }
}
