package com.example.todolist.exception;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(Integer id) {
        super(String.format("todo id %d not found", id));
    }
}
