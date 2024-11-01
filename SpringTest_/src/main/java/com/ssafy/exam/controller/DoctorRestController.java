package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {

	@Autowired
	private DoctorService doctorservice;

	@PostMapping("") // 의사 정보 등록
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) throws Exception {
		boolean result = doctorservice.addDoctor(doctor);
//		return ResponseEntity.status(result ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).build();
		return result ? ResponseEntity.status(HttpStatus.CREATED).body("Doctor added successfully")
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add doctor");
	}

	@GetMapping("") // 의사 전체 정보 조회
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> list = doctorservice.getAllDoctors();
		if (list != null && list.size() != 0) {
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{doctorId}") // 의사 개인 정보 조회
	public ResponseEntity<Doctor> getDoctorById(@PathVariable("doctorId") int doctorId) {
		Doctor doctor = doctorservice.getDoctorById(doctorId);
		return doctor != null ? ResponseEntity.status(HttpStatus.OK).body(doctor)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping("/{doctorId}") // 의사 개인 정보 수정
	public ResponseEntity<String> updateDoctor(@RequestBody Doctor doctor, @PathVariable("doctorId") int doctorId) {
		boolean result = doctorservice.updateDoctor(doctorId, doctor);
//		return ResponseEntity.status(result ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR).build();
		return result ? ResponseEntity.status(HttpStatus.OK).body("Doctor updated successfully")
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update doctor");
	}

	@DeleteMapping("/{doctorId}") // 의사 개인 정보 삭제
	public ResponseEntity<String> deleteDoctor(@PathVariable("doctorId") int doctorId) {
		boolean result = doctorservice.deleteDoctor(doctorId);
		if (result)
			return ResponseEntity.status(HttpStatus.OK).body("Doctor deleted successfully");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete doctor");
	}
}
