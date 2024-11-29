package com.school.SchoolApp.repository;

import com.school.SchoolApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByMattayomLevelAndClassNumber(int mattayomLevel, int classNumber);

    Student getStudentById(Long studentId);
}
