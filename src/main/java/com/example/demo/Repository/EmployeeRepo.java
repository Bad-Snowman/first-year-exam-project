package com.example.demo.Repository;

import com.example.demo.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo {
    @Autowired
    JdbcTemplate template;

    public List<Employee> fetchAll(){
        String sql = "SELECT * FROM employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    public Employee addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (employeeFirstName, employeeLastName, employeeEmail, employeePhone) VALUES(?, ?, ?, ?)";
        template.update(sql, employee.getEmployeeFirstName(), employee.getEmployeeLastName(), employee.getEmployeeEmail(), employee.getEmployeePhone());
        return null;
    }

    public boolean deleteEmployee(int employeeID) {
        String sql = "DELETE FROM employee WHERE employeeID=?";
        return template.update(sql, employeeID) > 0;
    }

    public Employee findEmployeeByID(int employeeID){
        String sql = "SELECT * FROM employee WHERE employeeID = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = template.queryForObject(sql, rowMapper, employeeID);
        return employee;
    }

    public Employee updateEmployee(int employeeID, Employee employee){
        String sql = "UPDATE employee SET employeeFirstName = ?, employeeLastName = ?, " +
                "employeeEmail = ?, employeePhone = ? WHERE employeeID = ?";
        template.update(sql, employee.getEmployeeFirstName(), employee.getEmployeeLastName(),
                employee.getEmployeeEmail(), employee.getEmployeePhone(), employee.getEmployeeID());
        return null;
    }
}
