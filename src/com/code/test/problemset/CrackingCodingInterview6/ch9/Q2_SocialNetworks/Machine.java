package com.code.test.problemset.CrackingCodingInterview6.ch9.Q2_SocialNetworks;

import java.util.HashMap;

public class Machine {
	public HashMap<Integer, Person> persons = new HashMap<Integer, Person>();
	public int machineID;
	
//	public Person getPersonWithID(int personID) {
//		return persons.get(personID);
//	}
	public Person getPersonWithID(int personID){
		return persons.get(personID);
	}
}
