package com.school.SchoolApp.repository;

import com.school.SchoolApp.model.Grade;
import com.school.SchoolApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Optional<Grade> findByStudentAndTerm(Student student, String term);
}
