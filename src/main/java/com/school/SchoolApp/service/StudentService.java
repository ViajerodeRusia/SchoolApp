package com.school.SchoolApp.service;

import com.school.SchoolApp.model.Student;
import com.school.SchoolApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudentsByClass(int mattayomLevel, int classNumber) {
        return studentRepository.findByMattayomLevelAndClassNumber(mattayomLevel, classNumber);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.getStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById((studentId));
    }
    // Add other methods as needed
}
