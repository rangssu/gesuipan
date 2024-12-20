package com.example.Gesuipan.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Gesuipan.DTO.UserDTO;
import com.example.Gesuipan.mapper.UserMapper;

import exception.DuplicateUserException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
	
	private final UserMapper userMapper;
	
	// 유저 등록(회원가입)
	@Transactional
	public void registerUser(UserDTO user) {
		UserDTO duplicateId = userMapper.findByUserId(user.getUserId());
		if(duplicateId != null) {
			throw new DuplicateUserException("중복 아이디 입니다.");
		}
		userMapper.registerUser(user);
	}
	
	// 로그인
	@Transactional
	public UserDTO login(String userId, String password) throws IllegalAccessException {
		UserDTO user = userMapper.findByUserId(userId);
		
		if (userId != null && user.getPassword().equals(password)) {
			return user;
		}else {
			throw new IllegalAccessException("로그인에 실패 하였습니다.");
		}
	}
}
