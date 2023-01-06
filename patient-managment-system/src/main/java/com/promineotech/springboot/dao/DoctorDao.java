package com.promineotech.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.promineotech.springboot.entity.DoctorEntity;

@EnableJpaRepositories
public interface DoctorDao extends JpaRepository<DoctorEntity, Long> {

	
	@Modifying
	@Query("update DoctorEntity d set d.firstName= :firstName")
	 void updateFirstName(@Param("firstName") String firstName);

}
