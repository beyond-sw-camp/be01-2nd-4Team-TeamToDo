package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.TodoEntity3;
import com.todo.service.PersonalTodoService;

@RestController
@RequestMapping("personal")
public class PersonalTodoController {
	
	@Autowired
	PersonalTodoService personalTodoService;
	
	// create
	@PostMapping("/insert")
	public TodoEntity3 insertTodo(@RequestBody TodoEntity3 todo) {
		todo.setCompleted(false);
		return personalTodoService.insertTodo(todo);
	}

	// read 
	@GetMapping("/get/{id}")
	public List<TodoEntity3> showTodoById(@PathVariable("id") Long personal_id) {
		return personalTodoService.showTodoById(personal_id);
	}

	
	// update
	@PostMapping("/update/{personal_id}/{content_id}")
	public TodoEntity3 updateTodo(@PathVariable("personal_id") Long personal_id,
								@PathVariable("content_id") Long content_id, 
								@RequestBody TodoEntity3 todo) {
		return personalTodoService.updateTodo(personal_id, content_id, todo);
	}

	@PutMapping("/updateCompleted/{personal_id}/{content_id}")
	public void updateCompleted(@PathVariable Long personal_id, @PathVariable Long content_id) {
		personalTodoService.updateCompleted(personal_id, content_id);
	}
	
	
	// delete
	@DeleteMapping("/delete/{personal_id}/{content_id}")
	public void deleteTodo(@PathVariable("personal_id") Long personal_id,
						@PathVariable("content_id") Long content_id) {
		personalTodoService.deleteTodo(personal_id, content_id);
	}
}
