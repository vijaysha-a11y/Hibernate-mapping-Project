package com.tcs.hibernate_jpa_mapping_many_to_one_controller;

import java.util.ArrayList;
import java.util.List;

import com.tcs.hibernate_jpa_mapping_many_to_one_dao.StatesDao;
import com.tcs.hibernate_jpa_mapping_many_to_one_dto.States;

public class InsertStateController {
	public static void main(String[] args) {
		States state1 = new States();
		state1.setId(1);
		state1.setName("KARNATKA");
		
		States state2 = new States();
		state2.setId(2);
		state2.setName("MAHARASTRA");
		
		States state3 = new States();
		state3.setId(3);
		state3.setName("TAMIL NADU");
		
		States state4 = new States();
		state4.setId(4);
		state4.setName("KERALA");
		
		List<States> states = new ArrayList<>();
		states.add(state1);
		states.add(state2);
		states.add(state3);
		states.add(state4);
		
		List<States> states2 = new StatesDao().saveStatesDao(states, 91);
	}
}
