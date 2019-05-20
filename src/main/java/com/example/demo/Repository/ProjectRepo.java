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


    // Handles the sql statements
    public List<Project> fetchAll() {
        String sql = "SELECT * FROM project";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>(Project.class);
        return template.query(sql, rowMapper);
    }

    public Project addProject(Project project) {
        String sql = "INSERT INTO project (projectName, projectDesc, projectManagerName, projectExpectedTime, projectUsedTime) VALUES(?, ?, ?, ?, ?)";
        template.update(sql, project.getProjectName(), project.getProjectDesc(), project.getProjectManagerName(), project.getProjectExpectedTime(), project.getProjectUsedTime());
        return null;
    }

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

    public Project updateProject(int projectID, Project project) {
        String sql = "UPDATE project SET projectName = ?, projectDesc = ?, projectManagerName = ?, " +
                "projectExpectedTime = ?, projectUsedTime = ? WHERE projectID=?";
        template.update(sql, project.getProjectName(), project.getProjectDesc(), project.getProjectManagerName(),
                project.getProjectExpectedTime(), project.getProjectUsedTime(), project.getProjectID());
        return null;
    }
}
