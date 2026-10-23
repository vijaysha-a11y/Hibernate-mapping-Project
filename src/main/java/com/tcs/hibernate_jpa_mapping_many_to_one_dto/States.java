package com.tcs.hibernate_jpa_mapping_many_to_one_dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class States {
	@Id
	private int id;;
	private String name;
	@ManyToOne
	@JoinColumn(name="countryid")
	private Country country;
}
