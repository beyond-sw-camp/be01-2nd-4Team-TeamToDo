package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.entity.TodoEntity2;
import com.todo.service.TeamTodoService;


@RestController
public class TeamTodoRestController {

	@Autowired
	public TeamTodoService teamTodoService;

	/*
	 * @RequestMapping("/session-login/teamtodo") public String teamRoot() { return
	 * "teamtodo"; }
	 */
	@RequestMapping("/list")
	public String listAll(Model model) {
		List<TodoEntity2> toDoEntityList2 = this.teamTodoService.showTodoAll();
		model.addAttribute("toDoEntityList2", toDoEntityList2);
		return "teamtodo";
	}
	
	// create
	@PutMapping("/insert")	
	public TodoEntity2 insertTodo(@RequestBody TodoEntity2 todo) {
		todo.setCompleted(false);

		return teamTodoService.insertTodo(todo);
	}

	// read
	@RequestMapping("{id}")
	public List<TodoEntity2> list(@PathVariable("id") Long team_id) {
		return teamTodoService.showTodoById(team_id);
	}

	/*
	 * // read
	 * 
	 * @ResponseBody
	 * 
	 * @GetMapping("/get/{id}") public List<TodoEntity2>
	 * showTodoById(@PathVariable("id") Long team_id) { return
	 * teamTodoService.showTodoById(team_id); }
	 */

	// update
	@PutMapping("/update/{team_id}/{content_id}")
	public void updateTodo(@PathVariable("team_id") Long team_id, @PathVariable("content_id") Long content_id,
			@RequestBody TodoEntity2 todo) {
		teamTodoService.updateTodo(team_id, content_id, todo);
	}
	
	@PutMapping("/updateCompleted/{team_id}/{content_id}")
	public void updateCompleted(@PathVariable Long team_id, @PathVariable Long content_id) {
		teamTodoService.updateCompleted(team_id, content_id);
	}

	// delete
	@DeleteMapping("/delete/{team_id}/{content_id}")
	public void deleteTodo(@PathVariable("team_id") Long team_id, @PathVariable("content_id") Long content_id) {
		teamTodoService.deleteTodo(team_id, content_id);
	}
}
