package com.promineotech.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.springboot.dao.DoctorDao;
import com.promineotech.springboot.dao.PatientDao;
import com.promineotech.springboot.entity.DoctorEntity;
import com.promineotech.springboot.entity.PatientEntity;
import com.promineotech.springboot.model.Doctor;
import com.promineotech.springboot.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	//Injecting dependency injection(Constructor based dependency injection)
	@Autowired
	private DoctorDao doctorDao;
	private PatientDao patientDao;
	
	public DoctorServiceImpl(PatientDao patientDao) {
		
		this.patientDao = patientDao;
	}

	//create constructor
	@Autowired	
    public DoctorServiceImpl(DoctorDao doctorDao) {
		
		this.doctorDao = doctorDao;
	}

	//Saving doctor
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		
		//The main game plan for this code is:
		//get the doctor from the database
		//create or set his/her first and last name
		//add patient to the doctor
		//save the patient 
		
		
		DoctorEntity  doctorEntity = new DoctorEntity();
		doctorEntity.setFirstName(doctor.getFirstName());
		doctorEntity.setLastName(doctor.getLastName());
		
		DoctorEntity savedEntity = doctorDao.save(doctorEntity);
		
		Doctor doctorController = Doctor.builder()
				.firstName(savedEntity.getFirstName())
				.lastName(savedEntity.getLastName())
				.id(savedEntity.getId()).build();	
		return doctorController;
	}

	//Get Doctor by Id
	@Override
	public Doctor getDoctor(Long id) {	
	Optional<DoctorEntity> optionalGetFrontEnd= doctorDao.findById(id);
    DoctorEntity getFrontEnd = optionalGetFrontEnd.get();
	Doctor doctorController = Doctor.builder()
			.firstName(getFrontEnd.getFirstName())
			.lastName(getFrontEnd.getLastName())
			.id(getFrontEnd.getId()).build();
		return doctorController;
	}
   //updating doctor info
	@Override
	public Doctor editDoctor(Doctor doctor) {
		Long doctorId = doctor.getId();
		Optional <DoctorEntity> optionalGetFrontEnd= doctorDao.findById(doctorId);
		if(optionalGetFrontEnd.isPresent()) {
		doctorDao.updateFirstName(doctor.getFirstName());
		return doctor;
		
		}
		return doctor;
	}
	
   //deleting doctor by Id
	@Override
	public void deleteDoctor(Long id) {
		doctorDao.deleteById(id);;
	}

	
	 @Override 
	 
	 public Doctor saveDoctorPatient(Doctor doctor, Long patientId) {
	  
	  DoctorEntity doctorEntity = new DoctorEntity();
	  doctorEntity.setFirstName(doctor.getFirstName());
	  doctorEntity.setLastName(doctor.getLastName());
	  //doctorEntity.setPatientList(doctor.getPatientList());
	  
	 
	 Optional <PatientEntity> optionalGetFrontEnd= patientDao.findById(patientId);
	  if(optionalGetFrontEnd.isPresent()) { 
		  
       PatientEntity patientEntity =optionalGetFrontEnd.get();
	 
	  //List<PatientEntity> patientList = new ArrayList<PatientEntity>();
	  //patientList.add(patientEntity); 
	  //doctorEntity.setPatientList(patientList);
	  doctorDao.save(doctorEntity);
	  
	 }
	 
		return doctor;
	 }
}
	
