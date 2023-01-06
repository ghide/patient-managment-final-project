package com.promineotech.springboot.model;

import java.util.List;

import javax.persistence.Entity;

import com.promineotech.springboot.entity.PatientEntity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder

public class Doctor {
	
    private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private List<PatientEntity> patientList;
	

}
