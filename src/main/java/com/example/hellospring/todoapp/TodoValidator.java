package com.example.hellospring.todoapp;

import com.example.hellospring.todoapp.model.Todo;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

// để kiểm tra xem 1 object Todo có hợp lệ hay không
public class TodoValidator {
    public boolean isValid(Todo todo) {
        return Optional.ofNullable(todo)
                .filter(t -> !StringUtils.isEmpty(t.getTitle()))
                .filter(t -> !StringUtils.isEmpty(t.getDetail()))
                .isPresent(); // trả về true nếu hợp lệ và ngược lại
    }
}
