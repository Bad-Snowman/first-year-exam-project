package com.example.demo.Model;

public class Employee {

    private int employeeID;
    private String employeeFirstName;
    private String employeeLaseName;
    private int employeePhone;
    private String employeeEmail;

    public Employee(int employeeID, String employeeFirstName, String employeeLaseName, int employeePhone, String employeeEmail) {
        this.employeeID = employeeID;
        this.employeeFirstName = employeeFirstName;
        this.employeeLaseName = employeeLaseName;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
    }

    ///////////////////////////////Getters and Setter/////////////////////
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

    public String getEmployeeLaseName() {
        return employeeLaseName;
    }

    public void setEmployeeLaseName(String employeeLaseName) {
        this.employeeLaseName = employeeLaseName;
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
