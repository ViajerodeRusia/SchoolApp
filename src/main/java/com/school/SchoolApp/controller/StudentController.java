package com.school.SchoolApp.controller;

import com.school.SchoolApp.model.Student;
import com.school.SchoolApp.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/manage")
    public String manageStudents(Model model, HttpServletRequest request) {
        model.addAttribute("students", studentService.getAllStudents());
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        model.addAttribute("_csrf", csrfToken);
        return "student-management";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/manage";
    }

    @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model, HttpServletRequest request) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        // Добавляем CSRF-токен в модель
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        model.addAttribute("_csrf", csrfToken);
        return "edit-student"; // шаблон для редактирования студента
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "redirect:/students/manage";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students/manage";
    }

    // Add other methods for editing and deleting students
}
