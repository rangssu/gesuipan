package com.example.Gesuipan.service;

import com.example.Gesuipan.DTO.BoardDTO;
import com.example.Gesuipan.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
//import repository.BoardRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements Boardservice {
	
	private final BoardMapper boardMapper;
	
	// 번호 갖고오는거
    @Override
    @Transactional
    public BoardDTO getPanById(int id) {
        return boardMapper.getPostById(id);
    }
	
    // 전체보기
	@Override
	@Transactional(readOnly = true)
    public List<BoardDTO> getAllPan() {
        return boardMapper.getAllPan();
    }
    
    // 게시물 저장하는 메서드
	@Override
	@Transactional
    public void insertpan(BoardDTO post) {
		boardMapper.insertpan(post);
    }
    
    // 게시물 업데이트하는 메서드
	@Override
	@Transactional
    public void updatepan(BoardDTO post) {
		boardMapper.updatepan(post);
    }
    
    // 게시물 삭제하는 메서드
	@Override
	@Transactional
    public void deletepan(int id) {
		boardMapper.deletepan(id);
    }
}

//	private final BoardRepository boardRepository;

//	public BoardServiceImpl(BoardMapper boardMapper) {
//		this.boardMapper = boardMapper;
//	}