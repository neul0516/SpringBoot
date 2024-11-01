package com.ssafy.exam.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.DoctorDao;
import com.ssafy.exam.model.dto.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorDao dao;

	@Override
	public boolean addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return dao.insertDoctor(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return dao.selectAllDoctors();
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return dao.selectDoctorById(id);
	}

	@Override
	public boolean updateDoctor(int id, Doctor doctor) {
		if(id != doctor.getDoctorId())
			return false;
		return dao.updateDoctor(doctor);
	}

	@Override
	public boolean deleteDoctor(int id) {
		int result = dao.deleteDoctor(id);
		return result==1;
	}

}
