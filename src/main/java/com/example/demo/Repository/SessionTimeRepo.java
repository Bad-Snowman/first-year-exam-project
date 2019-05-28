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

    // A method which sends a SELECT keyword to the database to retrieve all data from the 'sessionTime' table
    // it joins the employee and project table using inner joins
    public List<SessionTime> fetchAllSessionTimes() {
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

    // A method which uses the SELECT and WHERE keywords to show data from a specific sessionTime sorted by ID
    public SessionTime findSessionByID(int sessionTimeID) {
        String sql = "SELECT * FROM sessionTime WHERE sessionTimeID = ?";
        RowMapper<SessionTime> rowMapper = new BeanPropertyRowMapper<>(SessionTime.class);
        SessionTime sessionTime = template.queryForObject(sql, rowMapper, sessionTimeID);
        return sessionTime;
    }
    // A method which uses the DELETE and WHERE keywords to delete a specific row in the "sessionTime" table
    public boolean deleteSessionTime(String sessionTimeID) {
        String sql = "DELETE FROM sessionTime WHERE sessionTimeID=?";
        return template.update(sql, sessionTimeID) > 0;
    }

    // A method which uses the INSERT keyword to inject data into the 'sessionTime' table
    public SessionTime createSessionTime(SessionTime sessionTime) {
        String sql = "INSERT INTO sessionTime (sessionTimeDate, sessionTimeStart, sessionTimeEnd, " +
                "sessionTimeEmpID, sessionTimeProID) VALUES(?, ?, ?, ?, ?)";
        template.update(sql, sessionTime.getSessionTimeDate(), sessionTime.getSessionTimeStart(),
                sessionTime.getSessionTimeEnd(), sessionTime.getSessionTimeEmpID(),
                sessionTime.getSessionTimeProID());
        return null;
    }

    // A method which uses the UPDATE and WHERE keywords to modify a specific table sorted by ID
    public SessionTime editSessionTime(int sessionTimeID, SessionTime sessionTime) {
        String sql = "UPDATE sessionTime SET sessionTimeDate = ?, sessionTimeStart = ?, " +
                "sessionTimeEnd = ?, sessionTimeEmpID = ?, sessionTimeProID = ? WHERE sessionTimeID = ?";
        template.update(sql, sessionTime.getSessionTimeDate(), sessionTime.getSessionTimeStart(),
                sessionTime.getSessionTimeEnd(), sessionTime.getSessionTimeEmpID(),
                sessionTime.getSessionTimeProID(), sessionTime.getSessionTimeID());
        return null;
    }
}
