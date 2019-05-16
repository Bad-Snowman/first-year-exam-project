package com.example.demo.Controller;

import com.example.demo.Model.Employee;
import com.example.demo.Model.SessionTime;
import com.example.demo.Service.EmployeeService;
import com.example.demo.Service.ProjectManagerService;
import com.example.demo.Service.ProjectService;
import com.example.demo.Service.SessionTimeService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    ProjectManagerService projectManagerService;
    @Autowired
    ProjectService projectService;
    @Autowired
    SessionTimeService sessionTimeService;

    /////////// Root /////////////
    // All GetMapping and PostMapping related to the root

    @GetMapping("/")
    public String index() {
        return "home/MainMenu";
    }


    /////////////// Project ////////////
// All GetMapping and PostMapping related to project
    @GetMapping("/projectList")
    public String toProjectList() {
        return "home/ProjectList";
    }


    ////////// Employee //////////////
    // All GetMapping and PostMapping related to employee
    @GetMapping("employeeList")
    public String toEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.fetchAll();
        model.addAttribute("employees", employeeList);
        return "home/EmployeeList";
    }


    /////////// SessionTime ////////////
    // All GetMapping and PostMapping related to session
    @GetMapping("/sessionList")
    public String sessionList(Model model) {
        List<SessionTime> sessionList = sessionTimeService.fetchAll();
        model.addAttribute("sessionsTime", sessionList);
        return "Home/SessionList";
    }

    @GetMapping ("/delete/{sessionTimeID}")
    public String delete (@PathVariable("sessionTimeID") String sessionTimeID){
    boolean deleted = sessionTimeService.deleteSessionTime(sessionTimeID);
    if (deleted){
        return "redirect:/";
    }else{
        return "redirect:/";
    }
    }

}
