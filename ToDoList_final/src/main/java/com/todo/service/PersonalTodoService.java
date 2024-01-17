package com.todo.service;

import java.util.List;

import com.todo.entity.TodoEntity3;

public interface PersonalTodoService {
	// c
	TodoEntity3 insertTodo(TodoEntity3 todo);

	// r
	// TodoEntity2 showTodoAll();
	List<TodoEntity3> showTodoById(Long persoanl_id);

	// u
	TodoEntity3 updateTodo(Long personal_id, Long content_id, TodoEntity3 todo);

	// d
	void deleteTodo(Long personal_id, Long content_id);

	void updateCompleted(Long personal_id, Long content_id);
}
