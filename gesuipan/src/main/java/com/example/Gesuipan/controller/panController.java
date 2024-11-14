package com.example.Gesuipan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Gesuipan.mapper.panMapper;
import com.example.Gesuipan.service.panService;

@Controller
@RequestMapping("/*")
public class panController {

	private final panService panService;
	
	
    public panController(panService gesuipanService) {
        this.panService = gesuipanService;
    }
	
	@GetMapping
	public String getPan(Model model) {
		model.addAttribute("post", panService.getPan());
		return "gesuipan/list";
	}
	
}
