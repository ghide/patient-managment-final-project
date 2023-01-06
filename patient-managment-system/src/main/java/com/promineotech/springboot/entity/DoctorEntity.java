
package com.promineotech.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Table(name = "doctor")
public class DoctorEntity {

	// The game plan for this code is:
	// annotate the class as an entity and map to db table

	// define the fields

	// annotate the fields with db column names

	// ** set up mapping to List<PatientEntity> entity

	// create constructors

	// generate getter/setter methods

	// generate toString() method
    

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	/*
	 * @JoinColumn tells hibernate Look at the patient_id column in the doctor table
	 * use this information to help find patient for the doctor
	 * 
	 * Note:- If the join is for a unidirectional OneToMany mapping using a foreign
	 * key mapping strategy, the foreign key is in the table of the target entity.
	 * In this code I use a unidirectional OneToMany mapping
	 */
	
	public DoctorEntity() {

	}

	public DoctorEntity(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "DoctorEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	/*- If the join is for a ManyToMany mapping or 
	for a OneToOne or bidirectional ManyToOne/OneToMany mapping 
	using a join table, the foreign key is in a join table.
	
	- If the join is for an element collection, the foreign 
	key is in a collection table.*/

}
