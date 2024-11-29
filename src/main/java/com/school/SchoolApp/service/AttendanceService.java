package com.school.SchoolApp.service;

import com.school.SchoolApp.model.Attendance;
import com.school.SchoolApp.model.Student;
import com.school.SchoolApp.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceByStudentAndDateRange(Student student, LocalDate startDate, LocalDate endDate) {
        return attendanceRepository.findByStudentAndDateBetween(student, startDate, endDate);
    }

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Add other methods as needed
}
