package com.denis.vjezba40.dto;

import com.denis.vjezba40.models.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    @NotEmpty(message = "First name is required.")
    private String firstName;
    @NotEmpty(message = "Last name is required.")
    private String lastName;
    @NotEmpty(message = "Gender is required.")
    private String gender;
    @Min(value = 18, message = "You must be at least 18.")
    @Max(value = 65, message = "You must be younger than 65.")
    private int age;
    @Valid
    @NotNull(message = "Address is required.")
    private Address address;
    @NotEmpty(message = "You need to list at least one thing you interested in.")
    private List<String> interestedIn;
    private int spentInBooks;
}
