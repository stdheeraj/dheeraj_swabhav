package com.techlabs.mapStudent.test;

import java.util.ArrayList;

import com.techlabs.mapStudent.Student;

public class TestCollection {

	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		
		list.add(new Student(1, "dheeraj", 16));
		list.add(new Student(102, "Prasad", 16));
		list.add("10");
		list.add(10);
		
		for (Object t : list) {
			Student s=(Student)t;
			System.out.println(s.getName());
		}

	}

}
