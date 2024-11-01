package com.ssafy.exam.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

	@Autowired
	private SpecialtyDao dao;
	
	@Override //전공 정보 등록
	public boolean addSpecialty(Specialty specialty) {
		// TODO Auto-generated method stub
		return dao.insertSpecialty(specialty);
	}

	@Override // 전공 정보 조회
	public Specialty getSpecialtyByCode(int code) {
		
		return dao.selectSpecialtyByCode(code);
	}

	@Override //전공 정보 삭제 
	public boolean deleteSpecialty(int code) {
		int result = dao.deleteSpecialty(code);
		return result==1;
	}

	
	
}
