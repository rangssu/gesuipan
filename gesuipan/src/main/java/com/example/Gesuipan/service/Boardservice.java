package com.example.Gesuipan.service;

import java.util.List;

import com.example.Gesuipan.DTO.BoardDTO;

public interface Boardservice {
	    List<BoardDTO> getAllPan();  // 게시물 ID로 조회
	    BoardDTO getPanById(int id); // id 갖고오는거
	    void insertpan(BoardDTO post);  // 게시물 저장
	    void updatepan(BoardDTO post);  // 게시물 수정
	    void deletepan(int id);  // 게시물 삭제
}
