package com.example.demo.Controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.Service.ProjectManagerService;
import com.example.demo.Service.ProjectService;
import com.example.demo.Service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    ProjectManagerService projectManagerService;
    @Autowired
    ProjectService projectService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/")
    public String index(){return "home/MainMenu";}

    @GetMapping("/sessionList")
    public String toSessionList(){
        return "home/SessionList";
    }

    @GetMapping("/projectList")
    public String toProjectList(){
        return "home/ProjectList";
    }

    @GetMapping("employeeList")
    public String toEmployeeList(){
        return "home/EmployeeList";
    }
}
