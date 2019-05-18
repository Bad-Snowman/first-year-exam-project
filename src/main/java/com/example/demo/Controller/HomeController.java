package com.example.demo.Controller;

import com.example.demo.Model.Employee;
import com.example.demo.Model.Project;
import com.example.demo.Model.SessionTime;
import com.example.demo.Service.EmployeeService;
import com.example.demo.Service.ProjectManagerService;
import com.example.demo.Service.ProjectService;
import com.example.demo.Service.SessionTimeService;
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
    public String projectList(Model model) {
        List<Project> projectList = projectService.fetchAll();
        model.addAttribute("projects", projectList);
        return "Home/ProjectList";
    }

    @GetMapping("/updateProject/{projectID}")
    public String updateProject(@PathVariable("projectID") int projectID, Model model) {
        model.addAttribute("project", projectService.findProjectById(projectID));
        return "home/updateProject";
    }

    @PostMapping("/updateProject")
    public String updateProject(@ModelAttribute Project project) {
        projectService.updateProject(project.getProjectID(), project);
        return "redirect:/";
    }

    @GetMapping("/deleteProject/{projectID}")
    public String deleteProject(@PathVariable("projectID") String projectID) {
        boolean deleted = projectService.deleteProject(projectID);
        if (deleted) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    ////////// Employee //////////////
    // All GetMapping and PostMapping related to employee
    @GetMapping("employeeList")
    public String toEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.fetchAll();
        model.addAttribute("employees", employeeList);
        return "Home/EmployeeList";
    }

    @GetMapping("/addEmployee")
    public String addEmployee() {
        return "Home/addEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employeeList";
    }

    @GetMapping("/deleteEmployee/{employeeID}")
    public String deleteEmployee(@PathVariable("employeeID") int employeeID) {
        boolean deleted = employeeService.deleteEmployee(employeeID);
        if (deleted) {
            return "redirect:/employeeList";
        } else {
            return "redirect:/";
        }
    }

    /////////// SessionTime ////////////
    // All GetMapping and PostMapping related to session


    @GetMapping("/sessionList")
    public String sessionList(Model model) {
        List<SessionTime> sessionList = sessionTimeService.fetchAll();
        model.addAttribute("sessionsTime", sessionList);
        return "Home/SessionList";
    }

    @GetMapping("/deleteSessionTime/{sessionTimeID}")
    public String deleteSessionTime(@PathVariable("sessionTimeID") String sessionTimeID) {
        boolean deleted = sessionTimeService.deleteSessionTime(sessionTimeID);
        if (deleted) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping ("/update/{sessionTimeID}")
    public String update(@PathVariable("sessionTimeID") int sessionTimeID, Model model){
        model.addAttribute("sessions", sessionTimeService.getSessionTimeID(sessionTimeID));
        return "Home/SessionUpdate";
    }

    @PostMapping("/updateSession")
    public String update (@ModelAttribute SessionTime sessionTime) {
        sessionTimeService.updateSessionTime(sessionTime.getSessionTimeID(), sessionTime);
        return "redirect:/";
    }


}

