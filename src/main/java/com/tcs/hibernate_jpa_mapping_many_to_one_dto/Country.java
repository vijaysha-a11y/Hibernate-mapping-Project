package com.tcs.hibernate_jpa_mapping_many_to_one_dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Country {
	@Id
	private int id;
	private String name;
	private String capital;
}
