package com.example.salonmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.salonmanagement.service.EmployeeService;

@Controller
public class ViewController {

    private final EmployeeService employeeService;

    public ViewController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";  // index.html in templates
    }

    @GetMapping("/employees")
    public String employeesPage(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";  // employees.html in templates
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";  // about.html in templates
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";  // contact.html in templates
    }
}