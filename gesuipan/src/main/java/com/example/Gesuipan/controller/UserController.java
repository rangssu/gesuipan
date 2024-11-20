package com.example.Gesuipan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Gesuipan.DTO.UserDTO;
import com.example.Gesuipan.service.UserServiceImpl;

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
	
	//회원가입 처리
	@PostMapping("regist")
	public String registerUser(@ModelAttribute UserDTO user) {
		userService.registerUser(user);
		return "redirect:/user/login";	//회원가입 성공시 로그인 창으로
	}
	
	//로그인 화면
	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("user", new UserDTO());
		return "/login";
	}
	
	//로그인 처리
	@PostMapping("/login")
	public String loginUser(@ModelAttribute UserDTO user, HttpSession session, Model model) {
		UserDTO loginuser = userService.login(user.getUserId(), user.getPassword());
				// 아이디와 비밀번호를 확인 했을 때 null이 아니면,
				// 원래 했을땐 1 과 0으로 했던거 같은데 일단 null로 처리 했으니 null.
		if(loginuser != null) {
			session.setAttribute("loginUser", loginuser);
			return "redirect:/gesuipan";
		} else {
			return "/login";
		}
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/gesuipan";
	}
	
	
}