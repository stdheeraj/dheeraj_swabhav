package com.techlabs.students.test;

import com.techlabs.students.*;

public class TestStudentList {

	public static void main(String args[]) {

		Students s = new Students();
		s.sl.add("Dheeraj");
		s.sl.add("Prasad");
		s.sl.add("Bhavna");
		s.sl.add("Vipul");

		Serialize sd = new Serialize();
		sd.serializeStudentList(s);
		sd.deserializeStudentList();
	}

}
