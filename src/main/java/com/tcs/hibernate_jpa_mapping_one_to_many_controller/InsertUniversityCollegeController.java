package com.tcs.hibernate_jpa_mapping_one_to_many_controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.tcs.hibernate_jpa_mapping_one_to_many_dao.UniversityCollegeDao;
import com.tcs.hibernate_jpa_mapping_one_to_many_dto.College;
import com.tcs.hibernate_jpa_mapping_one_to_many_dto.University;

public class InsertUniversityCollegeController {

	public static void main(String[] args) {
		College college1 = new College();
		college1.setId(123569);
		college1.setName("srit");
		college1.setAddress("noida-sector-2");
		
		College college2 = new College();
		college2.setId(1235674);
		college2.setName("bncel");
		college2.setAddress("lucknow");
		
		College college3 = new College();
		college3.setId(12312);
		college3.setName("mcdip");
		college3.setAddress("Lucknow");
		
		List<College> colleges = new ArrayList<College>(Arrays.asList(college1,college2,college3));
		
		University university = new University();
		university.setId(401);
		university.setName("aktu");
		
		university.setColleges(colleges);
		
		new UniversityCollegeDao().saveUniversityCollegeDao(university, colleges);
		
	}
}
