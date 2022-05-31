package com.denis.vjezba40.migrations;

import com.denis.vjezba40.models.Student;
import com.denis.vjezba40.repositories.StudentRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.util.List;

@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "0001", id = "addMaleGenderToAllStudents", author = Authors.ARAMBASIC_DENIS)
    public void addMaleGenderToAllStudents(StudentRepository studentRepository) {
        List<Student> students = studentRepository.findAll();
        students.forEach(student -> student.setGender("Male") );
        studentRepository.saveAll(students);
    }
}
