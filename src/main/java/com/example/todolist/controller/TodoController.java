package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public Todo save(@RequestBody Todo todo) {
        return this.todoService.save(todo);
    }

    @PutMapping
    public Todo update(@RequestBody Todo todo) {
        return this.todoService.save(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return this.todoService.getAll();
    }

    @GetMapping("{stateTodo}")
    public List<Todo> getByStateTodo(@PathVariable("stateTodo") String stateTodo) {
        return this.todoService.getByStateTodo(stateTodo);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id) {
        this.todoService.deleteById(id);
    }

    @DeleteMapping("/clear-completed")
    public void deleteByState(){
        this.todoService.deleteByState();
    }
}
