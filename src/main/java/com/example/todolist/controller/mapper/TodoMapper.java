package com.example.todolist.controller.mapper;

import com.example.todolist.controller.dto.TodoCreateRequest;
import com.example.todolist.controller.dto.TodoUpdateRequest;
import com.example.todolist.entity.Todo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public Todo toEntity(TodoCreateRequest request) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(request, todo);
        return todo;
    }

    public Todo toEntity(TodoUpdateRequest request) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(request, todo);
        return todo;
    }
}
