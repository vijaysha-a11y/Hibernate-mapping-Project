package com.tcs.hibernate_jpa_mapping_many_to_many_dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Subject {
	@Id
	private int id;
	private String name;
	private String trainer;
	
	@ManyToMany(mappedBy="subjects")
	private List<Student> students;
}
