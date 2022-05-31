package com.denis.vjezba40.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @NotEmpty(message = "Post code is required.")
    private String postCode;
    @NotEmpty(message = "City is required.")
    private String city;
    @NotEmpty(message = "Country is required.")
    private String country;
}
