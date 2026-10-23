package com.tcs.hibernate.jpa.mapping.controller;

import com.tcs.hibernate.jpa.mapping.dao.PersonAdharDao;
import com.tcs.hibernate.jpa.mapping.dto.Adhar;
import com.tcs.hibernate.jpa.mapping.dto.Person;

public class DisplayPersonAdharController {
	public static void main(String[] args) {
		Person person = new PersonAdharDao().getPersonAdharByPersonId(3570);
		if(person !=  null) {
			System.out.println("id ="+person.getId());
			Adhar adhar = person.getAdhar();
			if(adhar != null) {
				System.out.println("AdharNumber ="+adhar.getAdharNumber());
			}
		}
	}
}
