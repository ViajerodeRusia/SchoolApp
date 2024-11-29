package com.school.SchoolApp.controller;

import com.school.SchoolApp.model.Grade;
import com.school.SchoolApp.model.Student;
import com.school.SchoolApp.service.GradingService;
import com.school.SchoolApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/grading")
public class GradingController {

    @Autowired
    private GradingService gradingService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentId}")
    public String gradingForm(@PathVariable Long studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        model.addAttribute("student", student);
        return "grading";
    }

    @PostMapping("/save")
    public String saveGrade(@ModelAttribute Grade grade) {
        gradingService.saveGrade(grade);
        return "redirect:/dashboard";
    }
}