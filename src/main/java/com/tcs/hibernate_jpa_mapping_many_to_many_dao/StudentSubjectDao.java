package com.tcs.hibernate_jpa_mapping_many_to_many_dao;

import java.util.List;

import com.tcs.hibernate_jpa_mapping_many_to_many_dto.Student;
import com.tcs.hibernate_jpa_mapping_many_to_many_dto.Subject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class StudentSubjectDao {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
	public List<Student> saveStudentAndSubjectDao(List<Student> students, List<Subject> subjects){
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try{
			if(students.isEmpty()|| subjects.isEmpty()) {
				return null;
			}
			
//			it will vonnect student reference with subject
			et.begin();
			
			for (Subject subject : subjects) {
				em.persist(subject);
			}
			
			for (Student student : students) {
				em.persist(student);
			}
			
			et.commit();
			return students;
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
	
	public Student getStudentAndAssociatedSubjectDao(int studentId) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Student> query = em.createQuery(
				"SELECT DISTINCT s FROM Student s " +
		                       "LEFT JOIN FETCH s.subjects "+
		                       "WHERE s.id = ?1",
		                       Student.class);
		query.setParameter(1, studentId);
		try {
			return query.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
