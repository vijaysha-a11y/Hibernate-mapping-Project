package com.tcs.hibernate_jpa_mapping_one_to_many_dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class College {
	@Id
	private int id;
	private String name;
	private String address;
	
	@ManyToOne
	private University university;
		
}
