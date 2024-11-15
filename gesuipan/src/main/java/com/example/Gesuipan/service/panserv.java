package com.example.Gesuipan.service;

import java.util.List;

import com.example.Gesuipan.DTO.panDTO;

public interface panserv {
	    List<panDTO> getAllPan();  // 게시물 ID로 조회
	    panDTO getPanById(int id); // id 갖고오는거
	    void insertpan(panDTO post);  // 게시물 저장
	    void updatepan(panDTO post);  // 게시물 수정
	    void deletepan(int id);  // 게시물 삭제
}
