package com.tcs.hibernate.jpa.mapping.dao;

import com.tcs.hibernate.jpa.mapping.dto.Adhar;
import com.tcs.hibernate.jpa.mapping.dto.Person;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PersonAdharDao {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	
	public Person savePersonAdharDao(Person person, Adhar adhar) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			if(person==null || adhar==null) {
				return null;
			}
//			it will connect adhar reference wtih person
			person.setAdhar(adhar);
			et.begin();
			em.persist(adhar);
			em.persist(person);
			et.commit();
			return person;
		}catch (Exception e) {
			if(et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
			return null;
		}finally {
			if(em.isOpen()) {
				em.close();
			}
		}
	}
	public Person getPersonAdharByPersonId(int personId) {
		EntityManager em = emf.createEntityManager();
		return em.find(Person.class, personId);
	}
	
	public boolean deleteAdharByAdharNumber(long adharNumber) {
//		code karna hai
		return false;
	}
}
