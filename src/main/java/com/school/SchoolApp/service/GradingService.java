package com.school.SchoolApp.service;

import com.school.SchoolApp.model.Grade;
import com.school.SchoolApp.model.Student;
import com.school.SchoolApp.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradingService {

    @Autowired
    private GradeRepository gradeRepository;

    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Optional<Grade> getGradeByStudentAndTerm(Student student, String term) {
        return gradeRepository.findByStudentAndTerm(student, term);
    }

    // Add other methods as needed
}