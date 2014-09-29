package com.fmt.rest.service.annotations;

import java.util.ArrayList;
import java.util.Collection;

public class PeopleService {

	public Person getByEmail(String email) {
		// TODO Auto-generated method stub
		return new Person("ftaylor92@bc.edu");
	}

	public Collection<Person> getPeople(int count) {
		Collection<Person> p= new ArrayList<Person>();
		
		p.add(new Person("ftaylor92@bc.edu"));
		
		return p;
	}

}
