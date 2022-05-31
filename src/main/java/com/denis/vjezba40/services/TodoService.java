package com.denis.vjezba40.services;

import com.denis.vjezba40.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class TodoService {
    @Value("${todos.url}") private String todosUrl;
    @Autowired private RestTemplate restTemplate;


    public List<Todo> getAllTodos() {
        Todo[] todos = restTemplate.getForObject(todosUrl, Todo[].class);
        return Arrays.asList(todos);
    }
}
