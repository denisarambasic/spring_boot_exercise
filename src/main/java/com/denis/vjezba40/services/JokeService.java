package com.denis.vjezba40.services;

import com.denis.vjezba40.models.JokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JokeService {
    @Value("${jokes.url}") private String jokesUrl;
    @Autowired private RestTemplate restTemplate;

    public JokeResponse getJokes() {
        JokeResponse jokes = restTemplate.getForObject(jokesUrl, JokeResponse.class);
        return jokes;
    }
}
