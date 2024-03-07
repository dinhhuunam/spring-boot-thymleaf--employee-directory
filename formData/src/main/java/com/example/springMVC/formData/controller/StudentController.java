package com.example.springMVC.formData.controller;

import com.example.springMVC.formData.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;
    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("student",new Student());
        System.out.println(countries);
        model.addAttribute("countries",countries);
        return "student-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent,
                              Model model){
        System.out.println(theStudent.getFirstName()+theStudent.getLastName());
        return "student-cf";
    }
}
