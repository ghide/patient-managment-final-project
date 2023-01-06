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
import javax.persistence.Table;


@Entity
@Table(name = "prescription")
public class PrescriptionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "prescription_name")
	private String prescriptionName;

	@Column(name = "refil_times")
	private Long refilTimes;

	  @ManyToMany(fetch= FetchType.LAZY, cascade=
	  {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.DETACH,
	  CascadeType.REFRESH})
	  
	  @JoinTable( name ="prescription_has_patient", 
	  joinColumns =@JoinColumn(name="prescription_id", referencedColumnName = "id"), 
	  inverseJoinColumns=@JoinColumn(name ="patient_id",referencedColumnName = "id") )
	  
	 
	private List<PatientEntity>patientEntity;

	public PrescriptionEntity() {

	}
	// creating parameterized constructor

	public PrescriptionEntity(String prescriptionName, Long refilTimes) {
		this.prescriptionName = prescriptionName;
		this.refilTimes = refilTimes;
	}
	// generate setters and getters using fields
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrescriptionName() {
		return prescriptionName;
	}

	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}
	public Long getRefilTimes() {
		return refilTimes;
	}
	public void setRefilTimes(Long refilTimes) {
		this.refilTimes = refilTimes;
	}
	  public List<PatientEntity> getPatientEntity() { return patientEntity; }
	  
	  public void setPatientEntity(List<PatientEntity> patientEntity) {
	  this.patientEntity = patientEntity; }
	  
	// generate toString()
	@Override
	public String toString() {
		return "PrescriptionEntity [id=" + id + ", prescriptionName=" + prescriptionName + ", refilTimes=" + refilTimes
				+ "]";
	}
}
