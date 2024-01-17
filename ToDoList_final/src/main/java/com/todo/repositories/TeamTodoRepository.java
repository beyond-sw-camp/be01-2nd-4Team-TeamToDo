package com.todo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo.entity.TodoEntity2;

@Repository
public interface TeamTodoRepository extends JpaRepository<TodoEntity2, Integer> {

	@Query(value = "SELECT * FROM todo_entity2 where team_id = ?", nativeQuery = true)
	List<TodoEntity2> getTodoById(Long team_id);

	@Query(value = "SELECT * FROM todo_entity2 where team_id = ? and content_id = ?", nativeQuery = true)
	TodoEntity2 showTodoUpdate(Long team_id, Long content_id);

	@Query(value = "DELETE FROM todo_entity2 where team_id = ? and content_id = ?", nativeQuery = true)
	void deleteTodoById(Long team_id, Long content_id);
	
	/*
	 * @Query(value =
	 * "UPDATE todo_entity2 set completed = ?, date = ?, team_content = ? where team_id = ? and content_id = ?"
	 * , nativeQuery = true) TodoEntity2 updateTodo(int team_id, int content_id);
	 */

}
