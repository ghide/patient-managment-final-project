package com.promineotech.springboot.model;



import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
@Builder
public class Prescription {
	
    private Long id;
	
	private String prescriptionName;
	
	private Long refilTimes;
	

}
