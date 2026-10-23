package com.tcs.hibernate.jpa.mapping.controller;

import java.time.LocalDate;

import com.tcs.hibernate.jpa.mapping.dao.PersonAdharDao;
import com.tcs.hibernate.jpa.mapping.dto.Adhar;
import com.tcs.hibernate.jpa.mapping.dto.Person;

public class InsertPersonAdharController {
	public static void main(String[] args) {
		Adhar adhar = new Adhar();
		adhar.setAdharNumber(788432125464l);
		adhar.setCareTaker("Vivek-tivari");
		adhar.setDob(LocalDate.parse("1957-11-29"));
		
		Person person = new Person();
		person.setId(45701);
		person.setName("abhishek");
		person.setEmail("abhishek@gmail.com");
		
		person.setAdhar(adhar);
		System.out.println(adhar.getAdharNumber());
		
		Person returnPerson = new PersonAdharDao().savePersonAdharDao(person, adhar);
		String msg = returnPerson != null?"data saved":"somethink went wrong";
		System.out.println(msg);
	}
}
