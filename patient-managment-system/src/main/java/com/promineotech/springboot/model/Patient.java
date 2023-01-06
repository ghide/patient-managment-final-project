package com.promineotech.springboot.model;



import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Builder
public class Patient {
	
	private Long id;
	
	private String firstName;
	
	
	private String lastName;
	

	private String email;
	
	
	
	
}
