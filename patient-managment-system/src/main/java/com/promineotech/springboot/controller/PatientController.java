package com.promineotech.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.springboot.model.Patient;
import com.promineotech.springboot.service.DoctorService;
import com.promineotech.springboot.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientController {

	@Autowired
	private PatientService patientService;
	//injecting patient service using constructor based injection
	
	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public PatientController(DoctorService doctorService) {
	}
	public PatientController() {
	};
	// build create(Data Insert) a doctor in patient  REST API
	// ResponseEntity is a class that use to generate REST API
	// we are using a @Postmapping because the method is Post HTTP request

	long prescriptionId =1;
	
	@PostMapping("/patient/prescription")
	public ResponseEntity<Patient> savePatientAndPrescription(@RequestBody Patient patient, Long prescriptionId){
		return new ResponseEntity<Patient>(patientService.savePrescription(patient,prescriptionId),
				HttpStatus.CREATED);
	}
	/*
	 * @PostMapping("/patient/doctor") public ResponseEntity<Doctor>
	 * saveDoctorAndPatient(@RequestBody Doctor doctor, @RequestParam Long
	 * patientId){ return new
	 * ResponseEntity<Doctor>(doctorService.saveDoctorPatient(doctor,
	 * patientId),HttpStatus.CREATED); }
	 */
	
	 @PostMapping("/patient") 
	 public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){ 
		 
		 return new ResponseEntity<Patient>(patientService.savePatient(patient)
				 ,HttpStatus.CREATED);
		
	}
	 //build get patient REST API
	@GetMapping("/patient")
	public ResponseEntity<Patient> getPatient(@RequestParam Long id){
		return new ResponseEntity<Patient>(patientService.getPatient(id)
	         ,HttpStatus.OK);
	}
	//save/update patient
	
	@PutMapping("/patient")
	public ResponseEntity<Patient> editPatient(@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.editPatient(patient)
				,HttpStatus.OK);
	}
	@DeleteMapping("/patient")
		public void deletePatient(@RequestParam Long id){
		patientService.deletePatient(id);
		}
	}

