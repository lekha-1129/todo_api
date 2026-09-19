package com.example.todo_api.service;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.todo_api.model.TodoModel;
import com.example.todo_api.repo.TodoRepository;
@Service 
public class TodoServiceImpl implements TodoService{

    public TodoRepository TodoRepo;

    public TodoServiceImpl(TodoRepository TodoRepo)
    {
        this.TodoRepo=TodoRepo;
    }
    @Override 
    public TodoModel createTodo(TodoModel task)
    {
        return TodoRepo.save(task);
    }

    @Override 
    public List<TodoModel> getAllTodo()
    {
        return TodoRepo.findAll();
    }
    
   

}
