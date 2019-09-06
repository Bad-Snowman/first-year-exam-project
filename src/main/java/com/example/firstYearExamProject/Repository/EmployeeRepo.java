package com.example.firstYearExamProject.Repository;

import com.example.firstYearExamProject.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

    // Lasse

@Repository
public class EmployeeRepo {
    @Autowired
    JdbcTemplate template;

    // A method which sends a SELECT keyword to the database to retrieve all data from the 'employee' table
    public List<Employee> fetchAllEmployees() {
        String sql = "SELECT * FROM employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    // A method which sends an INSERT keyword to the database
    public Employee createEmployee(Employee employee) {
        String sql = "INSERT INTO employee (employeeFirstName, employeeLastName, employeeEmail, employeePhone) " +
                "VALUES(?, ?, ?, ?)";
        template.update(sql, employee.getEmployeeFirstName(), employee.getEmployeeLastName(),
                employee.getEmployeeEmail(), employee.getEmployeePhone());
        return null;
    }

    // A method which uses a SELECT keyword with a WHERE clause to filter records by employeeID
    public Employee findEmployeeByID(int employeeID) {
        String sql = "SELECT * FROM employee WHERE employeeID = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = template.queryForObject(sql, rowMapper, employeeID);
        return employee;
    }

    // A method which uses an UPDATE keyword to modify the 'employee' table
    public Employee editEmployee(int employeeID, Employee employee) {
        String sql = "UPDATE employee SET employeeFirstName = ?, employeeLastName = ?, " +
                "employeeEmail = ?, employeePhone = ? WHERE employeeID = ?";
        template.update(sql, employee.getEmployeeFirstName(), employee.getEmployeeLastName(),
                employee.getEmployeeEmail(), employee.getEmployeePhone(), employee.getEmployeeID());
        return null;
    }

    /* Currently not possible because of conflicts with primary keys and foreign keys,
    look at deleteSessionTime in SessionTimeRepo for a working delete function

    public boolean deleteEmployee(int employeeID) {
        String sql = "DELETE FROM employee WHERE employeeID=?";
        return template.update(sql, employeeID) > 0;
    } */
}
