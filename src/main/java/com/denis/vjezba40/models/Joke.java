package com.denis.vjezba40.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Joke {
    @JsonProperty("id")
    private int id;
    @JsonProperty("joke")
    private String joke;
}
