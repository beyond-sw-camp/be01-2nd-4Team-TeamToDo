package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.entity.TodoEntity2;
import com.todo.entity.TodoEntity3;
import com.todo.repositories.PersonalTodoRepository;

@Service
public class PersonalTodoServiceImpl implements PersonalTodoService {

	@Autowired
	PersonalTodoRepository personalTodoRepository;

	// create
	@Override
	public TodoEntity3 insertTodo(TodoEntity3 todo) {
		return personalTodoRepository.save(todo);
	}

	// read
	@Override
	public List<TodoEntity3> showTodoById(Long personal_id) {
		return personalTodoRepository.getTodoById(personal_id);
	}

	// update
	@Override
	public TodoEntity3 updateTodo(Long personal_id, Long content_id, TodoEntity3 todo) {

		TodoEntity3 entity = personalTodoRepository.showTodoUpdate(personal_id, content_id);

		entity.setDate(todo.getDate());
		entity.setPersonal_content(todo.getPersonal_content());

		personalTodoRepository.save(entity);

		return entity;
	}

	@Override
	public void updateCompleted(Long personal_id, Long content_id) {
		TodoEntity3 toDoEntity = personalTodoRepository.showTodoUpdate(personal_id, content_id);

		toDoEntity.setCompleted(!toDoEntity.getCompleted());
		this.personalTodoRepository.save(toDoEntity);
		
	}
	
	// delete
	@Override
	public void deleteTodo(Long personal_id, Long content_id) {
		personalTodoRepository.deleteTodoById(personal_id, content_id);
	}

	

}
