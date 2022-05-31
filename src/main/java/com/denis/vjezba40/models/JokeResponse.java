package com.denis.vjezba40.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JokeResponse {
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private List<Joke> value;
}
