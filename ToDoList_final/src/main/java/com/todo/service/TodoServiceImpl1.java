package com.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.entity.TodoEntity1;
import com.todo.repositories.TodoRepository_1;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl1 implements TodoService1 {
	private final TodoRepository_1 toDoRepository;

//	@Override
//	public List<TodoEntity1> getList() {
//		return this.toDoRepository.findAll();
//	}

	@Override
	public List<TodoEntity1> findByCustomerNum(Long customerNum) {
		return this.toDoRepository.findBycustomernum(customerNum);
	}

	@Override
	public void create(String content, String date, Long customerNum) {
		TodoEntity1 toDoEntity = new TodoEntity1();
		toDoEntity.setDate(date);
		toDoEntity.setCustomernum(customerNum);
		toDoEntity.setContent(content);
		toDoEntity.setCompleted(false);
		this.toDoRepository.save(toDoEntity);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		TodoEntity1 toDoEntity = toDoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

		this.toDoRepository.delete(toDoEntity);
	}

	@Override
	@Transactional
	public void update(Integer id, TodoEntity1 todo) {
		TodoEntity1 toDoEntity = toDoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));

		toDoEntity.setContent(todo.getContent());
		toDoEntity.setDate(todo.getDate());
		this.toDoRepository.save(toDoEntity);
	}

	@Override
	@Transactional
	public void completedUpdate(Integer id) {
		TodoEntity1 toDoEntity = toDoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));
		toDoEntity.setCompleted(!toDoEntity.getCompleted());
		this.toDoRepository.save(toDoEntity);
	}

}