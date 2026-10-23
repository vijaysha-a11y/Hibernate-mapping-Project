package com.tcs.hibernate_jpa_mapping_many_to_one_dao;

import java.util.List;

import com.tcs.hibernate_jpa_mapping_many_to_one_dto.Country;
import com.tcs.hibernate_jpa_mapping_many_to_one_dto.States;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StatesDao {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	public List<States> saveStatesDao(List<States> states, int countryId){
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			
			Country country = em.find(Country.class, countryId);
			
			if(states == null || states.isEmpty() || country==null) {
				return null;
			}
			
			et.begin();
			
			for (States  states2 : states) {
				states2.setCountry(country);
				em.persist(states2);
			}
			
			et.commit();
			
			return states;
		}
		catch(Exception e) {
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
	public States getStatesCountryByStatesIdDao(int statesId) {
		EntityManager em = emf.createEntityManager();
		return em.find(States.class, statesId);
	}
	public List<States> getAllStatesAndAssociatedCountryDao(){
		return emf.createEntityManager().createQuery("from States").getResultList();
	}
}
