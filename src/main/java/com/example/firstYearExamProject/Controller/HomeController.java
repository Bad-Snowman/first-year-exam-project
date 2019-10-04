package com.example.firstYearExamProject.Controller;

import com.example.firstYearExamProject.LocalDateAndTime;
import com.example.firstYearExamProject.Model.Employee;
import com.example.firstYearExamProject.Model.Project;
import com.example.firstYearExamProject.Model.SessionTime;
import com.example.firstYearExamProject.Service.EmployeeService;
import com.example.firstYearExamProject.Service.ProjectService;
import com.example.firstYearExamProject.Service.SessionTimeService;
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
    // Oliver
    //All GetMapping and PostMapping related to the project object

    @GetMapping("/projectList")
    public String projectList(Model model) {
        List<Project> projectList = projectService.fetchAllProjects();
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

    @GetMapping("/createProject")
    public String createProject() {
        return "Home/CreateProject";
    }

    @PostMapping("/createProject")
    public String createProject(@ModelAttribute Project project) {
        projectService.createProject(project);
        return "redirect:/projectList";
    }

    /* Currently not possible because of conflicts with primary keys and foreign keys,
       look at deleteSession for a working delete function

       @GetMapping("/deleteProject/{projectID}")
       public String deleteProject(@PathVariable("projectID") String projectID) {
           boolean deleted = projectService.deleteProject(projectID);
           if (deleted) {
               return "redirect:/projectList";
           } else {
               return "redirect:/";
           }
       } */


    ////////// Employee //////////////
    // Lasse
    //All GetMapping and PostMapping related to the project object

    @GetMapping("employeeList")
    public String toEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.fetchAllEmployees();
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
    // Rasmus
    // Mathias
    //All GetMapping and PostMapping related to the project object

    @GetMapping("/sessionList")
    public String sessionList(Model model) {
        List<SessionTime> sessionList = sessionTimeService.fetchAllSessionTimes();
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


    @PostMapping("/editSession")
    public String editSession(@ModelAttribute SessionTime sessionTime) {
        sessionTimeService.editSessionTime(sessionTime.getSessionTimeID(), sessionTime);
        return "redirect:/sessionList";
    }

    @GetMapping("/createSession")
    public String createSession(Model model) {
        model.addAttribute("localTime", LocalDateAndTime.getCurrentTime());
        model.addAttribute("localDate", LocalDateAndTime.getCurrentDate());

        return "Home/CreateSession";
    }

    @PostMapping("/createSession")
    public String createSession(@ModelAttribute SessionTime sessionTime) {
        sessionTimeService.createSessionTime(sessionTime);
        return "redirect:/sessionList";
    }

    /* Currently not possible because of conflicts with primary keys and foreign keys,
    look at deleteSession for a working delete function

    @GetMapping("/deleteEmployee/{employeeID}")
    public String deleteEmployee(@PathVariable("employeeID") int employeeID) {
        boolean deleted = employeeService.deleteEmployee(employeeID);
        if (deleted) {
            return "redirect:/employeeList";
        } else {
            return "redirect:/";
        }
    } */

}

