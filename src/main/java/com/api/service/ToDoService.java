package com.api.service;

import com.api.models.Todo;
import com.api.repos.TodoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final TodoRepo todoRepo;
    public ToDoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> getAll() {
        return todoRepo.findAll();
    }

    public boolean add(Todo todo) {
        if (todo == null) return false;
        todoRepo.save(todo);
        return true;
    }
    public boolean update(Integer id) {
        Todo todo = todoRepo.findById(id).orElse(null);
        if (todo == null) return false;
        todo.setStatus(!todo.isStatus());
        todoRepo.save(todo);
        return true;
    }

    public boolean delete(int id) {
        Todo todo = todoRepo.findById(id).orElse(null);
        if (todo == null) return false;
        todoRepo.delete(todo);
        return true;
    }
}
