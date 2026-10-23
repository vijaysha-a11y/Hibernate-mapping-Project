package com.tcs.hibernate_jpa_mapping_one_to_many_dao;

import java.util.List;

import com.tcs.hibernate_jpa_mapping_one_to_many_dto.College;
import com.tcs.hibernate_jpa_mapping_one_to_many_dto.University;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UniversityCollegeDao {

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

	public University saveUniversityCollegeDao(University university, List<College> colleges) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
//		saved non-owing-side
			for (College college : colleges) {
				em.persist(college);
			}
//		saved owning-side
			em.persist(university);
			et.commit();
			return university;
		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
			return null;
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}
	
	public University getUniversityAndCollegeByUniversityIdDao(int  universityId) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(University.class, universityId);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
