package com.example.hellospring.todoapp;

import com.example.hellospring.todoapp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TodoValidator todoValidator;

    // get limit values, if limit is null -> getAll
    public List<Todo> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> todoRepository.findAll(PageRequest.of(0, value)).getContent())
                .orElse(todoRepository.findAll());
    }

    // add new Todo
    public Todo add(Todo todo) {
        if(todoValidator.isValid(todo))
            return todoRepository.save(todo);

        return null;
    }
}
