package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.ToDoEntity;
import com.todo.service.ToDoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ToDoController {

	@Autowired
	private ToDoService service;;

	@GetMapping(path = "/getList")
	public ResponseEntity<List<ToDoEntity>> getToDoList() {
		System.out.println("hasash");
		return new ResponseEntity<List<ToDoEntity>>(service.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = "addToDo/{todo}")
	public void addToDo(@RequestBody ToDoEntity todo) {
		service.save(todo);
	}
}
