package com.example.Gesuipan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.Gesuipan.DTO.UserDTO;

@Repository		//@Repository (퍼시스턴스 레이어, DB나 파일같은 외부 I/O 작업을 처리함)
@Mapper
public interface UserMapper {
	
	//회원가입  createUser라고 하기에는 좀그럼;
	void registerUser(UserDTO user);
	
	// id 로 검색
	UserDTO findByUserId(String userId);
	
}
