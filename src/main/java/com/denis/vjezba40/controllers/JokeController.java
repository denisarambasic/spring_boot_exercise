package com.denis.vjezba40.controllers;

import com.denis.vjezba40.models.JokeResponse;
import com.denis.vjezba40.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jokes")
public class JokeController {
    @Autowired private JokeService jokeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public JokeResponse getJokes() {
        return jokeService.getJokes();
    }
}
