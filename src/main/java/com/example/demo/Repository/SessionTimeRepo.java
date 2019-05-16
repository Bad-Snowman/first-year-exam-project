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

    public boolean deleteSessionTime(String sessionTimeID) {
        String sql = "DELETE FROM sessionTime WHERE sessionTimeID=?";
        return template.update(sql, sessionTimeID) > 0;
    }
//

}
