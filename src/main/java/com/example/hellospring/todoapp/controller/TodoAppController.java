package com.example.hellospring.todoapp.controller;

import com.example.hellospring.todoapp.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class TodoAppController {
    List<Todo> todoList = new CopyOnWriteArrayList<>();

    @GetMapping("/listTodo")
    public String index(Model model, @RequestParam(name = "limit", required = false) Integer limit) {
        model.addAttribute("todoList", (limit != null && limit >= 0) ? todoList.subList(0, limit) : todoList );
        return "listTodo";
    }

    @GetMapping("/addTodo")
    public String addTodo(Model model) {
        // thêm mới một đối tượng Todo vào model
        model.addAttribute("todo", new Todo());
        return "addTodo";
    }

    @PostMapping("/addTodo")
    public String addTodo(@ModelAttribute Todo todo) { // @ModelAtribute đánh dấu đối tượng được gửi lên bởi form request
        todoList.add(todo);
        return "success";
    }
}
