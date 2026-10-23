package com.tcs.hibernate_jpa_mapping_many_to_one_controller;

import java.util.List;

import com.tcs.hibernate_jpa_mapping_many_to_one_dao.StatesDao;
import com.tcs.hibernate_jpa_mapping_many_to_one_dto.Country;
import com.tcs.hibernate_jpa_mapping_many_to_one_dto.States;

public class GetAllStatesAndCountryController {
	public static void main(String[] args) {
		List<States> states = new StatesDao().getAllStatesAndAssociatedCountryDao();
		
		for (States states2 : states) {
			System.out.println(states2.getId());
			System.out.println(states2.getName());
			
			Country country = states2.getCountry();
			
			System.out.println(country.getId()+" "+country.getName()+" "+country.getCapital());
		}
	}
}
