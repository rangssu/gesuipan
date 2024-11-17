package com.example.Gesuipan.DTO;

import java.sql.Timestamp;

public class BoardDTO {
	private int id;
	private String title;
	private String content;
	private String writer;
	private Timestamp reg;
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getWriter() {
		return writer;
	}

	public Timestamp getReg() {
		return reg;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public void setReg(Timestamp reg) {
		this.reg = reg;
	}
	
	
	
	
}
