package com.todo.service;
//package com.todo.service;
//
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.todo.entity.TodoEntity1;
//import com.todo.repositories.TodoRepository_1;
//
//import lombok.RequiredArgsConstructor;
//
//@RequiredArgsConstructor
//@Service
//public class TodoService1 {
//	private final TodoRepository_1 toDoRepository;
//
//	public List<TodoEntity1> getList() {
//		return this.toDoRepository.findAll();
//	}
//	
//	
//	  public void create(String content){
//	        TodoEntity1 toDoEntity = new TodoEntity1();
//	        toDoEntity.setContent(content);
//	        toDoEntity.setCompleted(false);
//	        this.toDoRepository.save(toDoEntity);
//	    }
//}