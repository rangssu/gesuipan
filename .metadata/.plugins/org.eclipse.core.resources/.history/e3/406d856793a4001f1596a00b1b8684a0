package com.example.Gesuipan.mapper;

import com.example.Gesuipan.DTO.panDTO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface panMapper {
	List<panDTO> getAllPan();  // 게시물 ID로 조회
	panDTO getPanById(int id);
	void insertpan(panDTO post);
	void updatepan(panDTO post);
	void deletepan(int id);
}
