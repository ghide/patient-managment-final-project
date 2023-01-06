package com.promineotech.springboot.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.springboot.dao.PrescriptionDao;
import com.promineotech.springboot.entity.PrescriptionEntity;
import com.promineotech.springboot.model.Prescription;
import com.promineotech.springboot.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	
	//injecting dependency injection(Constructor based dependency injection
	//because a mandatory based parameter injection
	private PrescriptionDao prescriptionDao;

	@Autowired
	public PrescriptionServiceImpl(PrescriptionDao thePrescriptionDao) {
		prescriptionDao = thePrescriptionDao;
	}
     //saving prescription 
	@Override
	public Prescription savePrescription(Prescription prescription) {
		
		PrescriptionEntity prescriptionEntity = new PrescriptionEntity();
		prescriptionEntity.setPrescriptionName(prescription.getPrescriptionName());
		prescriptionEntity.setRefilTimes(prescription.getRefilTimes());
		//prescriptionEntity.setId(prescription.getId());
		
		PrescriptionEntity savedEntity = prescriptionDao.save(prescriptionEntity);
		
		Prescription prescriptionController = Prescription.builder()
				          .prescriptionName(savedEntity.getPrescriptionName())
				          .refilTimes(savedEntity.getRefilTimes())
				          .id(savedEntity.getId()).build();
	
		return prescriptionController;
	}
     //Get prescription by id
	@Override
	public Prescription getPrescription(Long id) {
		
		Optional<PrescriptionEntity> optionalGetFrontEnd = prescriptionDao.findById(id);
		PrescriptionEntity getFrontEnd= optionalGetFrontEnd.get();
		Prescription prescriptionController = Prescription.builder()
				.prescriptionName(getFrontEnd.getPrescriptionName())
				.refilTimes(getFrontEnd.getRefilTimes())
				.id(getFrontEnd.getId()).build();
		
		return prescriptionController;
	}
	//updating Prescription
	@Override
	public Prescription editPrescription(Prescription prescription) {
			Long prescriptionId = prescription.getId();
			Optional <PrescriptionEntity> optionalGetFrontEnd= prescriptionDao.findById(prescriptionId);
			if(optionalGetFrontEnd.isPresent()) {
			prescriptionDao.updateRefilTimes(prescription.getRefilTimes());
			return prescription;
			}
		return null;
	}

	//deleting prescription by Id
	@Override
	public void deletePrescription(Long id) {
		prescriptionDao.deleteById(id);	
	}
	
	//create constructor
	
	

}
