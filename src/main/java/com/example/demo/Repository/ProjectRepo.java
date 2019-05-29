package com.example.demo.Repository;


import com.example.demo.Model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepo {
    @Autowired
    JdbcTemplate template;

    // A method which uses the SELECT keyword to retrive all data from the 'project' table
    public List<Project> fetchAllProjects() {
        String sql = "SELECT * FROM project \n" +
                "JOIN  (SELECT  sec_to_time(  sum(time_to_sec(  TIMEDIFF(sessionTimeEnd, sessionTimeStart)))) \n" +
                "as projectUsedTime, sessionTimeProID FROM sessiontime GROUP BY sessionTimeProId)\n" +
                "AS tabel ON project.projectID = tabel.sessionTimeProID;";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>(Project.class);
        return template.query(sql, rowMapper);
    }

    // A method which uses the INSERT keyword to inject data into the 'project' table
    public Project createProject(Project project) {
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

    // A method which uses the UPDATE and WHERE keywords to modify a specific table sorted by ID
    public Project editProject(int projectID, Project project) {
        String sql = "UPDATE project SET projectName = ?, projectDesc = ?, projectManagerName = ?, " +
                "projectExpectedTime = ?, projectDeadline = ?, projectDone = ? " +
                "WHERE projectID = ?";
        template.update(sql, project.getProjectName(), project.getProjectDesc(), project.getProjectManagerName(),
                project.getProjectExpectedTime(), project.getProjectDeadline(),
                project.getProjectDone(), project.getProjectID());
        return null;
    }

 /* Currently not possible because of conflicts with primary keys and foreign keys,
    look at deleteSession for a working delete function

    public Boolean deleteProject(String projectID){
        String sql = "DELETE FROM project WHERE projectID = ?";
        return template.update(sql, projectID) > 0;
    } */
}

