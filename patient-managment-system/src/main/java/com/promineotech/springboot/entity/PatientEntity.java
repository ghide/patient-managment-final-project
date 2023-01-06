package com.promineotech.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class PatientEntity {
	
	     // annotate the class as an entity and map to db table
	
		// define the fields
			
		// annotate the fields with database column names
			
		// ** set up mapping to DoctorList entity
			
		// create constructors
			
		// generate getter/setter methods
			
		// generate toString() method
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "first_name") 
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	
	//In this case one patient is matching with many doctors
	//Doctor is a target entity
	
	 @OneToMany(fetch=FetchType.LAZY, cascade =CascadeType.ALL)
	// @GeneratedValue(strategy = GenerationType.AUTO)
	 @JoinColumn(name="patient_id")
	
	 private List<DoctorEntity> doctorList;
	 
	
	//In this case we are matching many patients with many prescriptionS
	 @ManyToMany(fetch= FetchType.LAZY, cascade=
	  {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH,
	  CascadeType.REFRESH})
	  
	  @JoinTable( name ="prescription_has_patient", 
	  joinColumns =@JoinColumn(name ="patient_id", referencedColumnName = "id"), 
	  inverseJoinColumns =@JoinColumn(name ="prescription_id",referencedColumnName = "id") ) 
	private List<PrescriptionEntity> prescriptionEntity;
	
	public PatientEntity() {
	}
	public PatientEntity(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<DoctorEntity> getDoctorList() {
		return doctorList;
	}
	public void setDoctorList(List<DoctorEntity> doctorList) {
		this.doctorList = doctorList;
	}

	  public List<PrescriptionEntity> getPrescriptionEntity() { 
		  return prescriptionEntity; 
		  } 
	  public void setPrescriptionEntity(List<PrescriptionEntity> prescriptionEntity) {
	  this.prescriptionEntity = prescriptionEntity; 
	  }
	 
	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
		+ "]";
	}
	
}
