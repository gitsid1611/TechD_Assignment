package com.Todo.Service;

import com.Todo.Exception.TodoException;
import com.Todo.Model.Todo;

import java.util.List;

public interface TodoService {

    public Todo registerTodo(Todo td)throws TodoException;

    public Todo updateTodo(Todo plant) throws TodoException;

    public Todo DeleteTodo(Todo plantId) throws TodoException;

    public Todo viewTodo(Integer seed_id) throws TodoException;

    public List<Todo> viewAllTodo() throws TodoException;


}
