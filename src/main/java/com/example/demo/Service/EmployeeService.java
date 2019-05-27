package com.example.demo.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> fetchAllEmployees() {
        return employeeRepo.fetchAllEmployees();
    }


    public Employee addEmployee(Employee employee){
        return employeeRepo.addEmployee(employee);

    }

    /* // Ikke muligt grundet fk og pk celler i sessions
    public boolean deleteEmployee(int employeeID) {
        return employeeRepo.deleteEmployee(employeeID);
    } */

    public Employee findEmployeeByID(int employeeID) {
        return employeeRepo.findEmployeeByID(employeeID);
    }

    public Employee editEmployee(int employeeID, Employee employee) {
        return employeeRepo.editEmployee(employeeID, employee);
    }


}
