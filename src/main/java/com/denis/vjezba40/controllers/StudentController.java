package com.denis.vjezba40.controllers;

import com.denis.vjezba40.dto.StudentRequest;
import com.denis.vjezba40.models.Student;
import com.denis.vjezba40.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createNewStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return studentService.createNewStudent(studentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(@PathVariable("studentId") String studentId) {
        return studentService.getStudentById(studentId);
    }

    @PutMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@PathVariable("studentId") String studentId, @Valid @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(studentId, studentRequest);
    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable("studentId") String studentId) {
        studentService.deleteStudentById(studentId);
    }

    //Custom Queries

    @GetMapping("/olderThan20")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudentsOlderThan20() {
        return studentService.getAllStudentsOlderThan20();
    }

    @GetMapping("/youngerThan20")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudentsYoungerThan20() {
        return studentService.getAllStudentsYoungerThan20();
    }

    @GetMapping("/interestedInIT")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudentsInterestedInIT() {
        return studentService.getAllStudentsInterestedInIT();
    }

    @GetMapping("/interestedInSport")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudentsInterestedInSport() {
        return studentService.getAllStudentsInterestedInSport();
    }
}
