package com.ssafy.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

@RestController
@RequestMapping("/api/specialty")
public class SpecialtyRestController {

	@Autowired
	private SpecialtyService service;

	@PostMapping("") // 전공 정보 등록
	public ResponseEntity<String> addSpecialty(@RequestBody Specialty specialty) {
		boolean result = service.addSpecialty(specialty);
    	return result ? ResponseEntity.status(HttpStatus.CREATED).body("Specialty added successfully") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add specialty");
//		return new ResponseEntity<>(result ? HttpStatus.CREATED("Specialty added successfully") : HttpStatus.INTERNAL_SERVER_ERROR.body("Failed to add specialty");

	}

	@GetMapping("/{specialtyCode}") // 전공 정보 조회
	public ResponseEntity<Specialty> getSpecialty(@PathVariable("specialtyCode") int specialtyCode) {
		Specialty specialty = service.getSpecialtyByCode(specialtyCode);
//		return ResponseEntity.ok(specialty);
		if(specialty != null) {
			return ResponseEntity.status(HttpStatus.OK).body(specialty);	
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{code}") // 전공 정보 삭제
	public ResponseEntity<String> deleteSpecialty(@PathVariable("code") int code) {
		boolean result = service.deleteSpecialty(code);
		if (result)
			return ResponseEntity.status(HttpStatus.OK).body("Specialty deleted successfully");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete specialty");
	}
}