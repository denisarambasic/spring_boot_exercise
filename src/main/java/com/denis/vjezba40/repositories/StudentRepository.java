package com.denis.vjezba40.repositories;

import com.denis.vjezba40.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentRepository extends MongoRepository<Student, String> {
    @Query("{age : {$gte : 20}}")
    List<Student> getAllStudentsOlderThan20();

    @Query("{interestedIn : 'sport'}")
    List<Student> getAllStudentsInterestedInSport();
}
