package com.example.Gesuipan.service;

import com.example.Gesuipan.DTO.panDTO;
import com.example.Gesuipan.mapper.panMapper;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class panService implements panserv {
	
	private final panMapper panmapper;
	
	public panService(panMapper panmapper) {
		this.panmapper = panmapper;
	}
	
	// 번호 갖고오는거
    @Override
    public panDTO getPanById(int id) {
        return panmapper.getPanById(id);
    }
	
    // 전체보기
	@Override
    public List<panDTO> getAllPan() {
        return panmapper.getAllPan();
    }
    
    // 게시물 저장하는 메서드
	@Override
    public void insertpan(panDTO post) {
		panmapper.insertpan(post);
    }
    
    // 게시물 업데이트하는 메서드
	@Override
    public void updatepan(panDTO post) {
		panmapper.updatepan(post);
    }
    
    // 게시물 삭제하는 메서드
	@Override
    public void deletepan(int id) {
		panmapper.deletepan(id);
    }
}
