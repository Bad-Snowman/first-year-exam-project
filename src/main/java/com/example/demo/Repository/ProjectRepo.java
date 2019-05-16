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
    public List<Project> fetchAll(){
        //her laver jeg sql koden
        String sql = "SELECT * FROM person";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>(Project.class);
        return template.query(sql, rowMapper);
    }

    public Project addProject(Project p){
        String sql = "INSERT INTO project (projectName, projectDesc, projectManager, projectExpectedTime) VALUES(?, ?)";
        template.update(sql, p.getProjectName(),p.getProjectDesc(),p.getProjectExpectedTime());
        return null;
    }

    public Project findProjectById(int id){
        String sql = "SELECT * FROM project WHERE projectID = ?";
        RowMapper<Project> rowMapper = new BeanPropertyRowMapper<>(Project.class);
        Project p = template.queryForObject(sql,rowMapper, id);
        return p;
    }
    public Boolean deleteProject(int projectID){
        String sql = "DELETE FROM project WHERE projectID = ?";
        return template.update(sql, projectID) > 0;
    }

    public Project updateProject(int projectID, Project p){
        String sql = "UPDATE project SET projectName = ?, projectDesc = ?, projectManager = ?, " +
                     "projectExpectedTime = ?, projectUsedTime = ?  WHERE projectID = ?";
        template.update(sql, p.getProjectName(), p.getProjectDesc(), p.getProjectExpectedTime(), p.getProjectUsedTime());
        return null;
    }
}
