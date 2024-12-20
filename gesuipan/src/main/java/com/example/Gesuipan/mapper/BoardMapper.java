package com.example.Gesuipan.mapper;

import com.example.Gesuipan.DTO.BoardDTO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardMapper {
	List<BoardDTO> getAllPan();  // 게시물 ID로 조회
	BoardDTO getPostById(@Param("id") int id);
	void insertpan(BoardDTO post);
	void updatepan(BoardDTO post);
	void deletepan(@Param("id") int id);
}
