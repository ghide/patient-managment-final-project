package com.promineotech.springboot.controller;

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

import com.promineotech.springboot.entity.PatientEntity;
import com.promineotech.springboot.model.Doctor;
import com.promineotech.springboot.model.Patient;
import com.promineotech.springboot.service.DoctorService;

@RestController
@RequestMapping("/api")
public class DoctorController {
	
	//injecting the dependency of doctorSdervice
	private DoctorService doctorService;
	private PatientEntity patientEntity;
	
     //creating constructor using injection
	public DoctorController(DoctorService doctorService) {
		
		this.doctorService = doctorService;
	}

	   long patientId =1;
		
		@PostMapping("/patient/doctor")     
		public ResponseEntity<Doctor> saveDoctorAndPatient(
				@RequestBody Doctor doctor, @RequestParam Long patientId){
			return new ResponseEntity<Doctor>(doctorService.saveDoctorPatient(
					doctor, patientId),HttpStatus.CREATED);
		}
		
		  @PostMapping("/doctor/patient") public ResponseEntity<Doctor>
		  saveDoctor(@RequestBody Patient patient, Doctor doctor){ return new
		  ResponseEntity<Doctor>(doctorService.saveDoctor(doctor),HttpStatus.CREATED);
		  }
		 
	
	//Build create doctor REST API
	//ResponseEntity is a generic class that use to generate REST API
	//We are using a @Postmapping because the method is Post HTTP request
		  
	@PostMapping("/doctor")     
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.saveDoctor(doctor)
				,HttpStatus.CREATED);
	}
	
	//Build Get Doctor REST API
	@GetMapping("/doctor")
	public ResponseEntity<Doctor> getDoctor(@RequestParam Long id){
		return new ResponseEntity<Doctor>(doctorService.getDoctor(id)
				,HttpStatus.OK);
	}
	@PutMapping("/doctor")
	public ResponseEntity<Doctor> editDoctor(@RequestBody Doctor doctor){
		return new ResponseEntity<Doctor>(doctorService.editDoctor(doctor)
				,HttpStatus.OK);
	}
	@DeleteMapping("/doctor")
		public void deleteDoctor(@RequestParam Long id){
		doctorService.deleteDoctor(id);
		}
		
	}

