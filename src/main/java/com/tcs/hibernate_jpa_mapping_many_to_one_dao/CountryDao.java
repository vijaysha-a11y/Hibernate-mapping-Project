package com.tcs.hibernate_jpa_mapping_many_to_one_dao;

import com.tcs.hibernate_jpa_mapping_many_to_one_dto.Country;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CountryDao {
	
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	public Country saveCountryDao(Country country) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			if(country == null) {
				return null;
			}
			
			et.begin();
			
			em.persist(country);
			
			et.commit();
			
			return  country;
		}catch(Exception e) {
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
}
