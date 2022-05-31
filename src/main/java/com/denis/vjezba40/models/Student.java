package com.denis.vjezba40.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@Document("students")
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private Address address;
    private List<String> interestedIn;
    private int spentInBooks;
}
