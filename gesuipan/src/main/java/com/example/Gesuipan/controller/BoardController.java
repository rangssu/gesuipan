package com.example.Gesuipan.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Gesuipan.DTO.BoardDTO;
import com.example.Gesuipan.service.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/gesuipan")
@RequiredArgsConstructor
public class BoardController {

	private final BoardServiceImpl boardService;

//	@RequiredArgsConstructor
//	public BoardController(BoardServiceImpl gesuipanService) {
//		this.boardService = gesuipanService;
//	}

	// 리스트 보이는것
	@GetMapping
	public String getPan(Model model) {
		List<BoardDTO> posts = boardService.getAllPan();
		model.addAttribute("posts", posts);
		return "/list";
	}

	// 글작성폼
	@GetMapping("/write")
	public String insertPanForm(Model model) {
		model.addAttribute("post", new BoardDTO());
		return "/form";
	}

	// 실재 글작성 요청
	@PostMapping
	public String insertPan(BoardDTO post) {
		boardService.insertpan(post);
		return "redirect:/gesuipan";
	}

	// 수정
	@GetMapping("/update/{id}")
	public String updatePanForm(@PathVariable("id") int id, Model model) {
		BoardDTO post = boardService.getPanById(id);
		model.addAttribute("post", post);
		return "/update";
	}

	// 수정 처리
	@PostMapping("/update/{id}")
	public String updatePan(@PathVariable("id") int id,@ModelAttribute BoardDTO post) {
		post.setId(id);
		boardService.updatepan(post);
		return "redirect:/gesuipan";
	}

	// 삭제
	@GetMapping("/{id}/delete")
	public String deletePan(@PathVariable("id") int id) {
		boardService.deletepan(id);
		return "redirect:/gesuipan";
	}

	// 글 내용
	@GetMapping("/content/{id}")
	public String getPostById(@PathVariable("id") int id, Model model) {
		BoardDTO post = boardService.getPanById(id);
		model.addAttribute("post", post);
		return "/content";
	}
}
