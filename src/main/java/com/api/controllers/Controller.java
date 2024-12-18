package com.api.controllers;

import com.api.models.Todo;
import com.api.repos.TodoRepo;
import com.api.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://rayimanoj8.github.io/todo-react/")
public class Controller {
    @Autowired
    public ToDoService service;

    @GetMapping
    public ResponseEntity<List<Todo>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatusCode.valueOf(200));
    }

    @PostMapping()
    public ResponseEntity<String> addTodo(
            @RequestBody
            Todo todo) {
        System.out.println(todo);
        boolean isTodoAdded = service.add(todo);
        if(isTodoAdded)
            return new ResponseEntity<>("Todo added successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Todo not added successfully", HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTodo(
            @PathVariable("id")
            int id) {
        boolean isTodoAdded = service.update(id);
        if(isTodoAdded)
            return new ResponseEntity<>("Todo updated successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Todo not updated unsuccessfully", HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(
            @PathVariable("id")
            int id) {
        boolean isTodoAdded = service.delete(id);
        if(isTodoAdded)
            return new ResponseEntity<>("Todo Deleted successfully", HttpStatus.CREATED);
        return new ResponseEntity<>("Todo Not Exists to delete", HttpStatus.NOT_ACCEPTABLE);
    }
}
