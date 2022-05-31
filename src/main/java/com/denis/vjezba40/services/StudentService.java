package com.denis.vjezba40.services;

import com.denis.vjezba40.dto.StudentRequest;
import com.denis.vjezba40.exceptions.StudentNotFoundException;
import com.denis.vjezba40.models.Student;
import com.denis.vjezba40.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired private StudentRepository studentRepository;
    @Autowired private MongoTemplate mongoTemplate;

    public Student createNewStudent(StudentRequest studentRequest) {
        Student student = Student.build(
                null,
                studentRequest.getFirstName(),
                studentRequest.getLastName(),
                studentRequest.getGender(),
                studentRequest.getAge(),
                studentRequest.getAddress(),
                studentRequest.getInterestedIn(),
                studentRequest.getSpentInBooks()
        );

        return studentRepository.insert(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String studentId) {
        return findById(studentId);
    }

    public Student updateStudent(String studentId, StudentRequest studentRequest) {
        Student student = findById(studentId);

        if (studentRequest.getFirstName() != null)
            student.setFirstName(studentRequest.getFirstName());
        if (studentRequest.getLastName() != null)
            student.setLastName(studentRequest.getLastName());
        if (studentRequest.getGender() != null)
            student.setGender(studentRequest.getGender());
        if (studentRequest.getAge() > 0)
            student.setAge(studentRequest.getAge());
        if (studentRequest.getAddress() != null)
            student.setAddress(studentRequest.getAddress());
        if (studentRequest.getInterestedIn() != null)
            student.setInterestedIn(studentRequest.getInterestedIn());
        if (studentRequest.getSpentInBooks() > 0)
            student.setSpentInBooks(studentRequest.getSpentInBooks());

        return studentRepository.save(student);
    }

    public void deleteStudentById(String studentId) {
        Student student = findById(studentId);
        studentRepository.delete(student);
    }

    private Student findById(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> {
            throw new StudentNotFoundException("Student with id: " + studentId + " don't exist.");
        });
    }

    public List<Student> getAllStudentsOlderThan20() {
        return studentRepository.getAllStudentsOlderThan20();
    }

    public List<Student> getAllStudentsYoungerThan20() {
        Query query = new Query();
        query.addCriteria(Criteria.where("age").lt(20));
        return mongoTemplate.find(query, Student.class);
    }

    public List<Student> getAllStudentsInterestedInIT() {
        Query query = new Query();
        query.addCriteria(Criteria.where("interestedIn").in("it"));
        return mongoTemplate.find(query, Student.class);
    }

    public List<Student> getAllStudentsInterestedInSport() {
        return studentRepository.getAllStudentsInterestedInSport();
    }
}
