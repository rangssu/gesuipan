package com.example.Gesuipan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Gesuipan.DTO.panDTO;
import com.example.Gesuipan.service.panService;

@Controller
@RequestMapping("/gesuipan")
public class panController {

	private final panService panService;
	
	
    public panController(panService gesuipanService) {
        this.panService = gesuipanService;
    }
	
    // 리스트 보이는것
	@GetMapping
	public String getPan(Model model) {
		model.addAttribute("post", panService.getAllPan());
		return "/list";
	}
	
	// 글작성폼
	@GetMapping("/write")
	public String insertPanForm(Model model) {
		model.addAttribute("post", new panDTO());
		return "/form";
	}
	
	// 실재 글작성 요청
	@PostMapping
	public String insertPan(panDTO post) {
		panService.insertpan(post);
		return "redirect:/gesuipan";
	}
	
	// 수정
	@GetMapping("/{id}/update")
	public String updatePanForm(@PathVariable int id, Model model) {
		//model.addAttribute("post", panService.);
		return "/update";
	}
	
	// 수정 처리
	@PostMapping("/{id}")
	public String updatePan(@PathVariable int id, panDTO post) {
		post.setId(id);
		panService.updatepan(post);
		return "redirect:/gesuipan";
	}
	
	// 삭제
	@GetMapping("/{id}/delete")
	public String deletePan(@PathVariable int id) {
		panService.deletepan(id);
		return "redirect:/gesuipan";
	}
	
	
}
