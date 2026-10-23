package com.tcs.hibernate_jpa_mapping_many_to_many_controller;

import java.util.List;

import com.tcs.hibernate_jpa_mapping_many_to_many_dao.StudentSubjectDao;
import com.tcs.hibernate_jpa_mapping_many_to_many_dto.Student;
import com.tcs.hibernate_jpa_mapping_many_to_many_dto.Subject;

public class GetStudentSubjectByStudentIdController {
	public static void main(String[] args) {
		Student student = new StudentSubjectDao().getStudentAndAssociatedSubjectDao(2);
		System.out.println(student.getId());
		
		List<Subject> subjects = student.getSubjects();
		for (Subject subject : subjects) {
			System.out.println(subject);
		}
	}
}
