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

import com.promineotech.springboot.model.Prescription;
import com.promineotech.springboot.service.PrescriptionService;

@RestController
@RequestMapping("/api")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	//injecting patient service using constructor injection
	
	public PrescriptionController(PrescriptionService thePrescriptionService) {
		
		prescriptionService = thePrescriptionService;
	}
	//build create patient REST API
	//ResponseEntity is a class that use to generate REST API
	//we are using a @Postmapping because the method is Post HTTP request
	
	@PostMapping("/prescription")     
	public ResponseEntity<Prescription> savePrescription(@RequestBody Prescription prescription){
		return new ResponseEntity<Prescription>(prescriptionService.savePrescription(prescription)
				
				,HttpStatus.CREATED);
	}
	@GetMapping("/prescription")
	public ResponseEntity<Prescription> getPrescription(@RequestParam Long id){
		return new ResponseEntity<Prescription>(prescriptionService.getPrescription(id)
				,HttpStatus.OK);
	}
	@PutMapping("/prescription")
	public ResponseEntity<Prescription> editPrescription(@RequestBody Prescription prescription){
		return new ResponseEntity<Prescription>(prescriptionService.editPrescription(prescription)
				
				,HttpStatus.OK);
	}
	@DeleteMapping("/prescription")
		public void deletePrescription(@RequestParam Long id){
		prescriptionService.deletePrescription(id);
		}
		
	}

