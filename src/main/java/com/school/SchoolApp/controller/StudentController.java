package com.school.SchoolApp.controller;

import com.school.SchoolApp.model.Student;
import com.school.SchoolApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/manage")
    public String manageStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student-management";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/manage";
    }

    // Add other methods for editing and deleting students
}
