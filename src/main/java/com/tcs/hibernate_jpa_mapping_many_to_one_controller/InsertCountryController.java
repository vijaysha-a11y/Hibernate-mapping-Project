package com.tcs.hibernate_jpa_mapping_many_to_one_controller;

import com.tcs.hibernate_jpa_mapping_many_to_one_dao.CountryDao;
import com.tcs.hibernate_jpa_mapping_many_to_one_dto.Country;

public class InsertCountryController {
	public static void main(String[] args) {
		Country country = new Country();
		country.setId(91);
		country.setName("india");
		country.setCapital("New-Delhi");
		
		new CountryDao().saveCountryDao(country);
	}
}
