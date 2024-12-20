package com.example.Gesuipan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Gesuipan.DTO.UserDTO;
import com.example.Gesuipan.service.UserServiceImpl;

import exception.DuplicateUserException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserServiceImpl userService;
	
	//회원가입
	@GetMapping("regist")
	public String registForm(Model model) {
		model.addAttribute("user", new UserDTO());
		return "/regist";
	}
	
	// TODO 현재 문제점 : id 체크를 만들지도 않았고, Unique로 지정하지도 않아서 중복값이 들어감
	//회원가입 처리
	@PostMapping("regist")
	public String registerUser(@ModelAttribute UserDTO user,BindingResult result , Model model) {
		if(result.hasErrors()) {
			return "/regist";
		}
		
		try {
			userService.registerUser(user);
			return "redirect:/user/login";	//회원가입 성공시 로그인 창으로
		} catch (DuplicateUserException e) {
			model.addAttribute("error", e.getMessage());
			 model.addAttribute("user", user);
			return "/regist";
		} catch (Exception e) {
			model.addAttribute("error", "알수 없는 오류 입니다.");
			 model.addAttribute("user", user);
			return "/regist";
		}
	}
	//로그인 화면
	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("user", new UserDTO());
		return "login";
	}
	
	//로그인 처리
	@PostMapping("/login")
	public String loginUser(@ModelAttribute UserDTO user, HttpSession session, Model model) {
		try {
		UserDTO loginuser = userService.login(user.getUserId(), user.getPassword());
			session.setAttribute("loginUser", loginuser);
			model.addAttribute("userId", loginuser.getUserId());
			return "redirect:/gesuipan";
		} catch (IllegalAccessException e) {
			model.addAttribute("error", e.getMessage());
			model.addAttribute("user", user);
			return "/login";
		} catch (Exception e) {
			model.addAttribute("error", "문제 발생");
			model.addAttribute("user", user);
			return "/login";
		}
		
	}
	// 아이디와 비밀번호를 확인 했을 때 null이 아니면, 
	// 원래 했을땐 1 과 0으로 했던거 같은데 일단 null로 처리 했으니 null.
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/gesuipan";
	}
	
	
}
