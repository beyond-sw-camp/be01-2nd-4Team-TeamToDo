package com.todo.service;

import java.util.List;

import com.todo.entity.TodoEntity2;


public interface TeamTodoService {
	// c
	TodoEntity2 insertTodo(TodoEntity2 todo);
	// r
	List<TodoEntity2> showTodoAll();
	List<TodoEntity2> showTodoById(Long team_id); 
	// u
	void updateTodo(Long team_id, Long content_id, TodoEntity2 todo);
	void updateCompleted(Long team_id, Long content_id);
	// d
	void deleteTodo(Long team_id, Long content_id);
}
