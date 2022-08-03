package com.example.todolist.controller;

import com.example.todolist.controller.dto.TodoCreateRequest;
import com.example.todolist.controller.dto.TodoUpdateRequest;
import com.example.todolist.controller.mapper.TodoMapper;
import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;

    public TodoController(TodoService todoService, TodoMapper todoMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
    }

    @GetMapping
    List<Todo> getAll() {
        return todoService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Todo create(@RequestBody TodoCreateRequest request) {
        Todo todo = todoMapper.toEntity(request);
        todo.setDone(false);
        return todoService.create(todo);
    }

    @PutMapping("/{id}")
    Todo updateById(@PathVariable Integer id, @RequestBody TodoUpdateRequest request) {
        return todoService.updateById(id, todoMapper.toEntity(request));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        todoService.deleteById(id);
    }
}
