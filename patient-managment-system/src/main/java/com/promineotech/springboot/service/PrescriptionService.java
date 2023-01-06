package com.promineotech.springboot.service;

import com.promineotech.springboot.model.Prescription;

public interface PrescriptionService {
	
	
	Prescription getPrescription(Long id);
	Prescription savePrescription(Prescription prescription);
	Prescription editPrescription(Prescription prescription);
	void deletePrescription(Long id);

}
