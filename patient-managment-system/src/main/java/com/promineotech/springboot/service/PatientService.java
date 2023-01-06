package com.promineotech.springboot.service;

import com.promineotech.springboot.model.Doctor;
import com.promineotech.springboot.model.Patient;
import com.promineotech.springboot.model.Prescription;

public interface PatientService {
	 
	//public void addPrescription(Prescription thePrescription);
	Patient savePrescription(Patient patient, Long prescriptionId);
	Patient saveDoctor(Doctor doctor, Long patientId);
	Patient savePatient(Patient patient);
	Patient getPatient(Long id);
	Patient editPatient(Patient patient);
	void deletePatient(Long id);
	Patient findByPatientId(int patientId );
    

}
