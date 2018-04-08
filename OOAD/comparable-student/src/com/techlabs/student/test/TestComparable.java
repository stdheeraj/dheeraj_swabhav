package com.techlabs.student.test;

import java.util.ArrayList;
import java.util.Collections;

import com.techlabs.student.Student;

public class TestComparable {

	public static void main(String[] args) {
		
		ArrayList<Student> sl=new ArrayList<Student>();

		Student s1=new Student(1, "Vipul");
		Student s2=new Student(2, "Dheeraj");
		Student s3=new Student(3, "Prashad");
		
		sl.add(s3);
		sl.add(s1);
		sl.add(s2);
		
		Collections.sort(sl);
		
		System.out.println("Student List\nID\tName");
		
		for (Student st : sl) {
			System.out.println(st.getId()+"\t"+st.getName());
		}

	}

}
