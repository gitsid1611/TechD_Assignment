package com.Todo.Service;

import com.Todo.Exception.TodoException;
import com.Todo.Model.Todo;
import com.Todo.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepo pl;

    @Override
    public Todo registerTodo(Todo td) throws TodoException {
        Todo mod = pl.save(td);

        if(mod!=null)
        {
            return mod;
        }
        else {
            throw new TodoException("Input is Not Correct");
        }
    }

    @Override
    public Todo updateTodo(Todo td) throws TodoException {
        Optional<Todo>opt=pl.findById(td.getId());

        if(opt.isPresent())
        {
            pl.save(td);

        }


        else {
            throw new TodoException("Todo with given id is not presesnt........");

        }

        return opt.get();
    }

    @Override
    public Todo DeleteTodo(Todo todoId) throws TodoException {
        Optional<Todo> found = pl.findById(todoId.getId());


        if(found.isPresent()) {
            pl.delete(todoId);


        }
        else {
            throw new TodoException("Cant delete this because no such id is present here");
        }

        return found.get();
    }

    @Override
    public Todo viewTodo(Integer seed_id) throws TodoException {
        Optional<Todo> id = pl.findById(seed_id);

        if(id.isEmpty()) {
            throw new TodoException("Id Was In-Correct");
        }
        else {
            return id.get() ;

        }
    }

    @Override
    public List<Todo> viewAllTodo() throws TodoException {
        List<Todo> allcus = pl.findAll();

        if(allcus.isEmpty()) {
            throw new TodoException("No Customer In The Detabase");
        }
        else {
            return allcus;
        }
    }
}
