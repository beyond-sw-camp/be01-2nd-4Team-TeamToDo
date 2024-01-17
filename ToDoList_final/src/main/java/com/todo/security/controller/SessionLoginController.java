package com.todo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.todo.entity.TodoEntity1;
import com.todo.entity.TodoEntity2;
import com.todo.security.dto.JoinRequest;
import com.todo.security.dto.LoginRequest;
import com.todo.security.entity.User;
import com.todo.security.service.UserService;
import com.todo.security.userrole.UserRole;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/session-login")
public class SessionLoginController {

    private final UserService userService;
    private final TodoEntity1 todoEntity1;
    private final TodoEntity2 todoEntity2;
    
    
    @GetMapping(value = {"", "/"})
    public String home(Model model, @SessionAttribute(name = "userId", required = false) Long userId) {
        model.addAttribute("loginType", "session-login");

        User loginUser = userService.getLoginUserById(userId);

        
        if(loginUser != null) {
            model.addAttribute("nickname", loginUser.getNickname());
            todoEntity1.setCustomernum(userId);
            todoEntity2.setPersonal_id(userId);
            return "redirect:/session-login/todo";
        }
        
      return "logout";
    }

    @GetMapping("/join")
    public String joinPage(Model model) {
        model.addAttribute("loginType", "session-login");
        model.addAttribute("joinRequest", new JoinRequest());
        return "join";
    }

    @PostMapping("/join")
    public String join(@Valid @ModelAttribute JoinRequest joinRequest, BindingResult bindingResult, Model model) {
        model.addAttribute("loginType", "session-login");

        // loginId 중복 체크
        if(userService.checkLoginIdDuplicate(joinRequest.getLoginId())) {
            bindingResult.addError(new FieldError("joinRequest", "loginId", "아이디가 중복됩니다."));
        }
        // 닉네임 중복 체크
        if(userService.checkNicknameDuplicate(joinRequest.getNickname())) {
            bindingResult.addError(new FieldError("joinRequest", "nickname", "닉네임이 중복됩니다."));
        }
        // password와 passwordCheck가 같은지 체크
        if(!joinRequest.getPassword().equals(joinRequest.getPasswordCheck())) {
            bindingResult.addError(new FieldError("joinRequest", "passwordCheck", "비밀번호가 일치하지 않습니다."));
        }

        if(bindingResult.hasErrors()) {
            return "join";
        }

        //////////
        userService.join(joinRequest);
        return "redirect:/session-login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginType", "session-login");

        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, BindingResult bindingResult,
                        HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("loginType", "session-login");

        User user = userService.login(loginRequest);

        // 로그인 아이디나 비밀번호가 틀린 경우 global error return
        if(user == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 틀렸습니다.");
        }

        if(bindingResult.hasErrors()) {
            return "login";
        }

        // 로그인 성공 => 세션 생성

        // 세션을 생성하기 전에 기존의 세션 파기
        httpServletRequest.getSession().invalidate();
        HttpSession session = httpServletRequest.getSession(true);  // Session이 없으면 생성
        // 세션에 userId를 넣어줌
        session.setAttribute("userId", user.getId());
        session.setMaxInactiveInterval(1800); // Session이 30분동안 유지

        return "redirect:/session-login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        model.addAttribute("loginType", "session-login");

        HttpSession session = request.getSession(false);  // Session이 없으면 null return
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/session-login";
    }

    @GetMapping("/info")
    public String userInfo(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
        model.addAttribute("loginType", "session-login");

        User loginUser = userService.getLoginUserById(userId);

        if(loginUser == null) {
            return "redirect:/session-login/login";
        }

        model.addAttribute("user", loginUser);
        return "info";
    }

    @GetMapping("/admin")
    public String adminPage(@SessionAttribute(name = "userId", required = false) Long userId, Model model) {
        model.addAttribute("loginType", "session-login");

        User loginUser = userService.getLoginUserById(userId);

        if(loginUser == null) {
            return "redirect:/session-login/login";
        }

        if(!loginUser.getRole().equals(UserRole.ADMIN)) {
            return "redirect:/session-login";
        }

        return "admin";
    }
}