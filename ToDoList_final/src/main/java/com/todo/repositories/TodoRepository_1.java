package com.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.entity.TodoEntity1;

public interface TodoRepository_1 extends JpaRepository<TodoEntity1,Integer>{

	List<TodoEntity1> findBycustomernum(Long customernum);
	
}
