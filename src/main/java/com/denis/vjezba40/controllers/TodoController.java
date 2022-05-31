package com.denis.vjezba40.controllers;

import com.denis.vjezba40.models.Todo;
import com.denis.vjezba40.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired private TodoService todoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }
}
