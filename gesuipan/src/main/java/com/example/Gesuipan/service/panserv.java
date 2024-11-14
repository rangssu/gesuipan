package com.example.Gesuipan.service;

import com.example.Gesuipan.DTO.panDTO;

public interface panserv {
	    panDTO getPan();  // 게시물 ID로 조회
	    void insertpan(panDTO post);  // 게시물 저장
	    void updatepan(panDTO post);  // 게시물 수정
	    void deletepan(int id);  // 게시물 삭제
}
