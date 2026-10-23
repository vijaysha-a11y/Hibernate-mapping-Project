package com.tcs.hibernate_jpa_mapping_many_to_many_dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
	@Id
	private int id;
	private String name;
	private String email;
	@ManyToMany
	private List<Subject> subjects;
}
