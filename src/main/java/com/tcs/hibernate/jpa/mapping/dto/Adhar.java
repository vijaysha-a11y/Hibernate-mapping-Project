package com.tcs.hibernate.jpa.mapping.dto;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Adhar {
	@Id
	private long adharNumber;
	private String careTaker;
	private LocalDate dob;
}
