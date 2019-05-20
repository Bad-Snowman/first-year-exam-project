package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private int employeeID;
    private String employeeFirstName;
    private String employeeLastName;
    private int employeePhone;
    private String employeeEmail;

    public Employee(){
    };

    public Employee(int employeeID, String employeeFirstName, String employeeLastName, int employeePhone, String employeeEmail) {
        this.employeeID = employeeID;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
    }

    ///////////////////////////////Getters and Setter///////////////////////
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public int getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(int employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }


}
