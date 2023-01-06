package com.promineotech.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.promineotech.springboot.entity.PatientEntity;

public interface PatientDao extends JpaRepository<PatientEntity, Long> {
	
	/*
	 * @Modifying
	 * @Query("update User u set u.active = false where u.lastLoginDate < :date")
	 * void deactivateUsersNotLoggedInSince(@Param("date") LocalDate date);
	 */
	@Modifying
	@Query("update PatientEntity p set p.email= :email")
	 void updateEmail(@Param("email") String email);	
}
