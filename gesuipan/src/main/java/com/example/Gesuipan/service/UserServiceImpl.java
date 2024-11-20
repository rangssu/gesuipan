package com.example.Gesuipan.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Gesuipan.DTO.UserDTO;
import com.example.Gesuipan.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
	
	private final UserMapper userMapper;
	
	// 유저 등록(회원가입)
	@Transactional
	public void registerUser(UserDTO user) {
		userMapper.registerUser(user);
	}
	
	// 로그인
	@Transactional
	public UserDTO login(String userId, String password) {
		UserDTO user = userMapper.findByUserId(userId);
		
		if (userId != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}
