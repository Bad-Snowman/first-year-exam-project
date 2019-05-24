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

    ////////// Autowire //////////////
    // We make sure to autowire our service-classes to our Homecontroller
    @Autowired
    EmployeeService employeeService;
    @Autowired
    ProjectManagerService projectManagerService;
    @Autowired
    ProjectService projectService;
    @Autowired
    SessionTimeService sessionTimeService;

    ///////// Root /////////////
    //All GetMapping and PostMapping related to the root

    @GetMapping("/")
    public String index() {
        return "Home/MainMenu";
    }

    ///////////// Project ////////////
    //All GetMapping and PostMapping related to project
    @GetMapping("/projectList")
    public String projectList(Model model) {
        List<Project> projectList = projectService.fetchAll();
        model.addAttribute("projects", projectList);
        return "Home/ProjectList";
    }

    @GetMapping("/projectDetails/{sessionTimeProID}")
    public String projectDetails(@PathVariable("sessionTimeProID") int projectID, Model model) {
        model.addAttribute("project", projectService.findProjectById(projectID));
        return "Home/EditProject";
    }

    @GetMapping("/editProject/{projectID}")
    public String editProject(@PathVariable("projectID") int projectID, Model model) {
        model.addAttribute("project", projectService.findProjectById(projectID));
        return "Home/EditProject";
    }

    @PostMapping("/editProject")
    public String editProject(@ModelAttribute Project project) {
        projectService.editProject(project.getProjectID(), project);
        return "redirect:/projectList";
    }

    /*// Ikke muligt grundet fk og pk celler i sessions

    @GetMapping("/deleteProject/{projectID}")
    public String deleteProject(@PathVariable("projectID") String projectID) {
        boolean deleted = projectService.deleteProject(projectID);
        if (deleted) {
            return "redirect:/projectList";
        } else {
            return "redirect:/";
        }
    } */

    @GetMapping("/createProject")
    public String createProject() {
        return "Home/CreateProject";
    }

    @PostMapping("/createProject")
    public String createProject(@ModelAttribute Project project) {
        projectService.createProject(project);
        return "redirect:/projectList";
    }

    ////////// Employee //////////////
    @GetMapping("employeeList")
    public String toEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.fetchAll();
        model.addAttribute("employees", employeeList);
        return "Home/EmployeeList";
    }

    @GetMapping("/createEmployee")
    public String createEmployee() {
        return "Home/CreateEmployee";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employeeList";
    }

    /*// Ikke muligt grundet fk og pk celler i sessions
    @GetMapping("/deleteEmployee/{employeeID}")
    public String deleteEmployee(@PathVariable("employeeID") int employeeID) {
        boolean deleted = employeeService.deleteEmployee(employeeID);
        if (deleted) {
            return "redirect:/employeeList";
        } else {
            return "redirect:/";
        }
    } */

    @GetMapping("/employeeDetails/{sessionTimeEmpID}")
    public String employeeDetails(@PathVariable("sessionTimeEmpID") int employeeID, Model model) {
        model.addAttribute("employees", employeeService.findEmployeeByID(employeeID));
        return "Home/EditEmployee";
    }

    @GetMapping("/editEmployee/{employeeID}")
    public String editEmployee(@PathVariable("employeeID") int employeeID, Model model) {
        model.addAttribute("employees", employeeService.findEmployeeByID(employeeID));
        return "Home/EditEmployee";
    }

    @PostMapping("/editEmployee")
    public String editEmployee(@ModelAttribute Employee employee) {
        employeeService.editEmployee(employee.getEmployeeID(), employee);
        return "redirect:/employeeList";
    }

    /////////// SessionTime ////////////
    @GetMapping("/sessionList")
    public String sessionList(Model model) {
        List<SessionTime> sessionList = sessionTimeService.fetchAll();
        model.addAttribute("sessionsTime", sessionList);
        return "Home/SessionList";
    }

    @GetMapping("/deleteSession/{sessionTimeID}")
    public String deleteSessionTime(@PathVariable("sessionTimeID") String sessionTimeID) {
        boolean deleted = sessionTimeService.deleteSessionTime(sessionTimeID);
        if (deleted) {
            return "redirect:/sessionList";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/editSession/{sessionTimeID}")
    public String editSession(@PathVariable("sessionTimeID") int sessionTimeID, Model model) {
        model.addAttribute("sessions", sessionTimeService.findSessionByID(sessionTimeID));
        return "Home/EditSession";
    }

    @PostMapping("/editSession")
    public String editSession(@ModelAttribute SessionTime sessionTime) {
        sessionTimeService.editSessionTime(sessionTime.getSessionTimeID(), sessionTime);
        return "redirect:/sessionList";
    }


    @GetMapping("/createSession")
    public String createSession(Model model) {
        model.addAttribute("localTime", sessionTimeService.getCurrentTimeUsingDate());
        model.addAttribute("localDate", sessionTimeService.getCurrentDate());

        return "Home/CreateSession";
    }

    @PostMapping("/createSession")
    public String createSession(@ModelAttribute SessionTime sessionTime) {
        sessionTimeService.createSessionTime(sessionTime);
        return "redirect:/sessionList";
    }

    ///////////// Project Manager \\\\\\\\\\\\\\\\\\

    @GetMapping("/projectManagerList")
    public String toProjectManagerList(){
        return "Home/ProjectManagerList";
    }

    @GetMapping("/projectManagerReport")
    public String makeReport(){
        return "home/ProjectManagerReport";
    }

}

