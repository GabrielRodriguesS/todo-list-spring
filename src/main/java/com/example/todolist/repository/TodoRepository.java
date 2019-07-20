package com.example.todolist.repository;

import com.example.todolist.model.StateTodo;
import com.example.todolist.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findAllByStateTodo(StateTodo stateTodo);
    void deleteAllByStateTodo(StateTodo stateTodo);
}
