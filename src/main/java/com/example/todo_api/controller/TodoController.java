package com.example.todo_api.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_api.model.TodoModel;
import com.example.todo_api.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController 
// http://localhost:8080/todos
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoSer;
    public TodoController(TodoService todoser)
    {
        this.todoSer=todoser;
    }

    // http://localhost:8080/todos/createTodo
    @PostMapping("/createTodo")
    public TodoModel createTodo(@RequestBody TodoModel task)
    {
        return todoSer.createTodo(task);
    }

    @GetMapping("/getTodo")
    public List<TodoModel> getAllTodo()
    {
        return todoSer.getAllTodo();
    }

    @PutMapping("/updateTodo/{id}")
    public TodoModel updateTodo(@PathVariable Long id,@RequestBody TodoModel task)
    {
        return todoSer.updateTodo(id, task);
    }

    @DeleteMapping("/deleteTodo/{id}")
    public String deleteTodo(@PathVariable Long id)
    {
        todoSer.deleteTodo(id);
        return "ur task has been deleted";

    }

}
