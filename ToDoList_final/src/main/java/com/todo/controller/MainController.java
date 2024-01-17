package com.todo.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.entity.TodoEntity1;
import com.todo.service.TodoServiceImpl1;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController extends TodoEntity1{

	private final TodoServiceImpl1 toDoService;

	@GetMapping("/session-login/todo/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    new SecurityContextLogoutHandler().logout(request, response,
	            SecurityContextHolder.getContext().getAuthentication());
	    return "redirect:/session-login";
	}
	
	
	
	@RequestMapping("/session-login/todo")
	public String list(Model model) {
		Long x = getCustomernum();
		
		List<TodoEntity1> toDoEntityList = this.toDoService.findByCustomerNum(x);
		model.addAttribute("toDoEntityList", toDoEntityList);
		return "Todo";
	}	
	
	
	

	@RequestMapping("/")
	public String root() {
		return "redirect:/session-login/login";
	}

	@PostMapping("/todo/create")
	public String todoCreate(@RequestParam String content, @RequestParam String date, Long customerNum) {
		this.toDoService.create(content, date, getCustomernum());
		return "redirect:/session-login/todo";
	}

	@DeleteMapping("/session-login/todo/delete/{id}")
	public String todoDelete(@PathVariable Integer id) {
		this.toDoService.delete(id);
		return "redirect:/session-login/todo";
	}

	@PutMapping("/session-login/todo/update/{id}")
	public String todoUpdate(@RequestBody TodoEntity1 todo, @PathVariable Integer id) {
		this.toDoService.update(id, todo);
		return "redirect:/session-login/todo";
	}

	@PutMapping("/session-login/todo/completedUpdate/{id}")
	public String completedUpdate(@PathVariable Integer id) {
		this.toDoService.completedUpdate(id);
		return "redirect:/session-login/todo";
	}

}
