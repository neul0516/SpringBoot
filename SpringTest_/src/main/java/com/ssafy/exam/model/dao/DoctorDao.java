package com.ssafy.exam.model.dao;

import java.util.List;

import com.ssafy.exam.model.dto.Doctor;

public interface DoctorDao {
    boolean insertDoctor(Doctor doctor);
    List<Doctor> selectAllDoctors();
    Doctor selectDoctorById(int id);
    boolean updateDoctor(Doctor doctor);
    int deleteDoctor(int id);
}
