package com.example.todolist.service;

import com.example.todolist.model.StateTodo;
import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo save(Todo todo) {
        return this.todoRepository.save(todo);
    }

    public List<Todo> getAll() {
        Iterable<Todo> source = this.todoRepository.findAll();
        List<Todo> target = new ArrayList<>();
        source.forEach(target::add);
        return target;
    }

    public List<Todo> getByStateTodo(String stateTodo) {
        return this.todoRepository.findAllByStateTodo(StateTodo.valueOf(stateTodo.toUpperCase()));
    }

    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    @Transactional
    public void deleteByState() {
        this.todoRepository.deleteAllByStateTodo(StateTodo.COMPLETED);
    }
}
