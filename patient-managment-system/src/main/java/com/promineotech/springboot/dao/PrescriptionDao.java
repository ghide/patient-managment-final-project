package com.promineotech.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.promineotech.springboot.entity.PrescriptionEntity;

//@NoRepositoryBean
@EnableJpaRepositories
public interface PrescriptionDao extends JpaRepository<PrescriptionEntity, Long> {
	
	@Modifying
	@Query("update PrescriptionEntity p set p.refilTimes= :refilTimes")
	 void updateRefilTimes(@Param("refilTimes") Long refilTimes);

	
	

}
