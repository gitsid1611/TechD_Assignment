package com.Todo.Controller;

import com.Todo.Exception.TodoException;
import com.Todo.Model.Todo;
import com.Todo.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoService ps;


    @PostMapping("/add")
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody Todo cs) throws TodoException {

        if(cs==null)
        {
            throw new TodoException("Not Saved");
        }
        else {
            Todo add = ps.registerTodo(cs);

            return new ResponseEntity<Todo>(add, HttpStatus.ACCEPTED);
        }



    }



//	................Plant

    @PutMapping("/update")
    ResponseEntity<Todo> updateTodo(@RequestBody Todo td)throws TodoException{




        Todo updated = ps.updateTodo(td);
        return new ResponseEntity<Todo>(updated, HttpStatus.ACCEPTED);



    }


    @DeleteMapping("/delete/{id}")
    ResponseEntity<Todo> DeleteTodo(@PathVariable("id") Todo td) throws TodoException{

        Todo pe = ps.DeleteTodo(td);

        return new ResponseEntity<Todo>(pe ,HttpStatus.ACCEPTED);

    }


    @GetMapping("/viewAllplant")
    public ResponseEntity<List<Todo>> viewAll()throws TodoException{

        List<Todo> find = ps.viewAllTodo();

        return new ResponseEntity<List<Todo>>(find,HttpStatus.ACCEPTED);

    }



    @GetMapping("/viewPlantById/{id}")
    public ResponseEntity<Todo> findbyid(@PathVariable("id") int id)throws TodoException{

        Todo byid = ps.viewTodo(id);

        return new ResponseEntity<Todo>(byid,HttpStatus.ACCEPTED);

    }



}
