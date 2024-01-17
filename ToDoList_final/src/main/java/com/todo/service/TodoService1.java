package com.todo.service;

import java.util.List;

import com.todo.entity.TodoEntity1;

public interface TodoService1 {

	// public List<TodoEntity1> getList();

	public List<TodoEntity1> findByCustomerNum(Long Customer_num);

	public void create(String content, String date, Long customerNum);

	public void delete(Integer id);

	public void update(Integer id, TodoEntity1 todo);

	public void completedUpdate(Integer id);
}
