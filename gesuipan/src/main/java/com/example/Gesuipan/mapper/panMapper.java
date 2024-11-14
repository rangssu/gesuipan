package com.example.Gesuipan.mapper;

import com.example.Gesuipan.DTO.panDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface panMapper {
	panDTO getPan();
	void insertpan(panDTO post);
	void updatepan(panDTO post);
	void deletepan(int id);
}