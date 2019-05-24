package com.example.demo.Repository;

import com.example.demo.Interfaces.ProjectUsedTime;
import com.example.demo.Model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepo implements ProjectUsedTime {
    @Autowired
    JdbcTemplate template;

    ////////////////////// VIRKER IKKE /////////////////////////
    public double convertToHours (String time){
        String[] hourMinSec = time.split(":");
        int hour = Integer.parseInt(hourMinSec[0]);
        int min = Integer.parseInt(hourMinSec[1]);
        double total = hour + (min * 1.6666666666666666666666666666667 / 100);
        return total;
    }

    ///////////////////// VIRKER IKKE ////////////////////////////
    @Override
    public double calculateUsedTime() {
        List<Project> list;
        String sql = "SELECT TIMEDIFF(sessionTimeEnd, sessionTimeStart) FROM sessionTime WHERE sessionTimeEmpID = 1;";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>();
        list = template.query(sql, rowMapper);
        double calc;
        return 0;
    }

    // A method which uses the SELECT keyword to retrive all data from the 'project' table
    public List<Project> fetchAll() {
        String sql = "SELECT * FROM project";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>(Project.class);
        return template.query(sql, rowMapper);
    }

    // A method which uses the INSERT keyword to inject data into the 'project' table
    public Project addProject(Project project) {
        String sql = "INSERT INTO project (projectName, projectDesc, projectManagerName, projectExpectedTime, " +
                "projectUsedTime, projectDeadline, projectDone) VALUES(?, ?, ?, ?, ?, ?, ?)";
        template.update(sql, project.getProjectName(), project.getProjectDesc(), project.getProjectManagerName(),
                project.getProjectExpectedTime(), project.getProjectUsedTime(), project.getProjectDeadline(),
                project.getProjectDone());
        return null;
    }

    // A method which uses the SELECT and WHERE keywords to show data from a specific project sorted by ID
    public Project findProjectById(int projectID) {
        String sql = "SELECT * FROM project WHERE projectID = ?";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>(Project.class);
        Project project = template.queryForObject(sql, rowMapper, projectID);
        return project;
    }

    /* Ikke muligt grundet fk og pk celler i sessions
    public Boolean deleteProject(String projectID){
        String sql = "DELETE FROM project WHERE projectID = ?";
        return template.update(sql, projectID) > 0;
    } */

    // A method which uses the UPDATE and WHERE keywords to modify a specific table sorted by ID
    public Project updateProject(int projectID, Project project) {
        String sql = "UPDATE project SET projectName = ?, projectDesc = ?, projectManagerName = ?, " +
                "projectExpectedTime = ?, projectUsedTime = ?, projectDeadline = ?, projectDone = ? " +
                "WHERE projectID = ?";
        template.update(sql, project.getProjectName(), project.getProjectDesc(), project.getProjectManagerName(),
                project.getProjectExpectedTime(), project.getProjectUsedTime(), project.getProjectDeadline(),
                project.getProjectDone(), project.getProjectID());
        return null;
    }

}

