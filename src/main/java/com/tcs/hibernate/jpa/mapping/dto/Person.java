package com.tcs.hibernate.jpa.mapping.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {
	@Id
	private int id;
	private String name;
	private String email;
	
//	@OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "adhar_number")
	@OneToOne
	private Adhar adhar;
	
}
