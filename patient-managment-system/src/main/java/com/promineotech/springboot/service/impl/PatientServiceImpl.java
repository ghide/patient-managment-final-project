package com.promineotech.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.springboot.dao.DoctorDao;
import com.promineotech.springboot.dao.PatientDao;
import com.promineotech.springboot.dao.PrescriptionDao;
import com.promineotech.springboot.entity.DoctorEntity;
import com.promineotech.springboot.entity.PatientEntity;
import com.promineotech.springboot.entity.PrescriptionEntity;
import com.promineotech.springboot.model.Doctor;
import com.promineotech.springboot.model.Patient;
import com.promineotech.springboot.model.Prescription;
import com.promineotech.springboot.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	    //injecting dependency injection(Constructor based dependency injection
		//because a mandatory based parameter injection
	@Autowired
	 private PatientDao patientDao;
	 
	 //create constructor
	@Autowired
	public PatientServiceImpl(PatientDao thePatientDao) {
		patientDao = thePatientDao;
	}
	//saving patient
	@Override
	public Patient savePatient(Patient patient) {
		
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setFirstName(patient.getFirstName());
		patientEntity.setLastName(patient.getLastName());
		patientEntity.setEmail(patient.getEmail());
		
		PatientEntity savedEntity = patientDao.save(patientEntity);
		
		Patient patientController = Patient.builder()
				.firstName(savedEntity.getFirstName())
				.email(savedEntity.getEmail())
				.lastName(savedEntity.getLastName()).id(savedEntity.getId()).build();
		
              return patientController;
	}
	//get patient by id
	@Override
	public Patient getPatient(Long id) {
		Optional <PatientEntity> optionalGetFrontEnd= patientDao.findById(id);
		PatientEntity getFrontEnd = optionalGetFrontEnd.get();
		Patient patientController = Patient.builder()
				.firstName(getFrontEnd.getFirstName())
				.email(getFrontEnd.getEmail())
				.lastName(getFrontEnd.getLastName()).id(getFrontEnd.getId()).build();
		
		return patientController;
	}

	//updating patient
	@Override
	public Patient editPatient(Patient patient) {
		Long patientId = patient.getId();
		Optional <PatientEntity> optionalGetFrontEnd= patientDao.findById(patientId);
		if(optionalGetFrontEnd.isPresent()) {
		patientDao.updateEmail(patient.getEmail());
		return patient;
		
		}
		return null;
	}
	
    //deleting patient by Id
	@Override
	public void deletePatient(Long id) {
		patientDao.deleteById(id);
	
	}
	@Override
	public Patient saveDoctor(Doctor doctor, Long patientId) {
		
		DoctorEntity  doctorEntity = new DoctorEntity();
		doctorEntity.setFirstName(doctor.getFirstName());
		doctorEntity.setLastName(doctor.getLastName());
		
	 Optional <PatientEntity> optionalGetFrontEnd= patientDao.findById(patientId);
	if(optionalGetFrontEnd.isPresent()) {
	 PatientEntity patientEntity = optionalGetFrontEnd.get();
	 
	   List<DoctorEntity> doctorList = new ArrayList<DoctorEntity>();
	   doctorList.add(doctorEntity);
	   patientEntity.setDoctorList(doctorList);
	   patientDao.save(patientEntity);
	}
	
	return null;
	}
	@Override
	public Patient savePrescription(Patient patient, Long prescriptionId) {
		
		PrescriptionEntity  prescriptionEntity = new PrescriptionEntity();
		prescriptionEntity.setPrescriptionName(prescriptionEntity.getPrescriptionName());
		prescriptionEntity.setRefilTimes(prescriptionEntity.getRefilTimes());
		
	 Optional <PatientEntity> optionalGetFrontEnd= patientDao.findById(prescriptionId);
	if(optionalGetFrontEnd.isPresent()) {
	 PatientEntity patientEntity = optionalGetFrontEnd.get();
	 
	   List<PrescriptionEntity> prescriptionList = new ArrayList<PrescriptionEntity>();
	   prescriptionList.add(prescriptionEntity);
	  patientEntity.setPrescriptionEntity(prescriptionList);
	   patientDao.save(patientEntity);
	}
		return null;
	}
	@Override
	public Patient findByPatientId(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * public List<Prescription> getPrescriptionName(){ return Prescription; }
	 * 
	 * @Override public void addPrescription(Prescription prescriptionList) {
	 * if(prescriptionList==null) { prescriptionList = new ArrayList<>(); }
	 * prescriptionList.add() }
	 */
	

}
