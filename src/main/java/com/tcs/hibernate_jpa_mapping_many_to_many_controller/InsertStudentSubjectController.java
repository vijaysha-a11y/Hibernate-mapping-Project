package com.tcs.hibernate_jpa_mapping_many_to_many_controller;

import java.util.ArrayList;
import java.util.List;

import com.tcs.hibernate_jpa_mapping_many_to_many_dao.StudentSubjectDao;
import com.tcs.hibernate_jpa_mapping_many_to_many_dto.Student;
import com.tcs.hibernate_jpa_mapping_many_to_many_dto.Subject;

public class InsertStudentSubjectController {
	public static void main(String[] args) {
//		create 4 Subjects
		Subject s1 = new Subject(); 
		s1.setId(101);
		s1.setName("java");
		s1.setTrainer("Rahul");
		
		Subject s2 = new Subject();
		s2.setId(102);
		s2.setName("Python");
		s2.setTrainer("Amit");
		
		Subject s3 = new Subject();
		s3.setId(103);
		s3.setName("SQL");
		s3.setTrainer("Priya");
		
		Subject s4 = new Subject();
		s4.setId(104);
		s4.setName("Hibernate");
		s4.setTrainer("Rohit");
		
		List<Subject> subjects = new ArrayList<>();
		subjects.add(s1);
		subjects.add(s2);
		subjects.add(s3);
		subjects.add(s4);
		
//		Create 3 student objects
		Student st1 = new Student();
		st1.setId(1);
		st1.setName("Aman");
		st1.setEmail("aman@gmail.com");
		st1.setSubjects(subjects);
		
		Student st2 =  new Student();
		st2.setId(2);
		st2.setName("Rohan");
		st2.setEmail("rohan@gmail.com");
		st2.setSubjects(subjects);
		
		Student st3 = new Student();
		st3.setId(3);
		st3.setName("Neha");
		st3.setEmail("neha@gmail.com");
		st3.setSubjects(subjects);
		
		List<Student> students = new ArrayList<>();
		students.add(st1);
		students.add(st2);
		students.add(st3);
//		Call DAO method
		
		StudentSubjectDao dao = new StudentSubjectDao();
		List<Student> result = dao.saveStudentAndSubjectDao(students, subjects);
		System.out.println("Student and Subjects saved successfully!");
		
	}
}
