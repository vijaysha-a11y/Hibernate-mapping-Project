package com.tcs.hibernate_jpa_mapping_one_to_many_dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class University {
	@Id
	private int id;
	private String name;
	@OneToMany
	private List<College> colleges;
}
