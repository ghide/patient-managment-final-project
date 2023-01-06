package com.promineotech.springboot.service;

import com.promineotech.springboot.model.Doctor;
import com.promineotech.springboot.model.Patient;

public interface DoctorService {
	
	
	//Adding patient to a doctor 
	Doctor saveDoctorPatient(Doctor doctor, Long patientId);
	Doctor saveDoctor(Doctor doctor);
	Doctor getDoctor(Long id);
	Doctor editDoctor(Doctor doctor);
	void deleteDoctor(Long id);

}
