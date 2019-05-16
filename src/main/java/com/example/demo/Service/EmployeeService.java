package com.example.demo.Service;

import com.example.demo.Model.Employee;
import com.example.demo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> fetchAll(){
        return employeeRepo.fetchAll();
    }
}
