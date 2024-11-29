package com.school.SchoolApp.controller;

import com.school.SchoolApp.model.Attendance;
import com.school.SchoolApp.model.Student;
import com.school.SchoolApp.service.AttendanceService;
import com.school.SchoolApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/{mattayomLevel}/{classNumber}")
    public String getAttendancePage(@PathVariable int mattayomLevel,
                                    @PathVariable int classNumber,
                                    Model model) {
        List<Student> students = studentService.getStudentsByClass(mattayomLevel, classNumber);
        LocalDate today = LocalDate.now();

        model.addAttribute("students", students);
        model.addAttribute("date", today);
        model.addAttribute("className", "Mattayom " + mattayomLevel + "/" + classNumber);

        return "attendance";
    }

    @PostMapping("/save")
    public String saveAttendance(@RequestParam Long studentId,
                                 @RequestParam LocalDate date,
                                 @RequestParam Attendance.AttendanceStatus status) {
        Student student = studentService.getStudentById(studentId);
        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setDate(date);
        attendance.setStatus(status);
        attendanceService.saveAttendance(attendance);

        return "redirect:/attendance/" + student.getMattayomLevel() + "/" + student.getClassNumber();
    }
}
