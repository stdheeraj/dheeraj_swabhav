package com.techlabs.student.test;

import java.util.ArrayList;
import java.util.Collections;

import com.techlabs.student.SortById;
import com.techlabs.student.SortByName;
import com.techlabs.student.Student;

public class TestComparator {

	public static void main(String[] args) {

		ArrayList<Student> sl = new ArrayList<Student>();

		Student s1 = new Student(1, "Vipul");
		Student s2 = new Student(2, "Dheeraj");
		Student s3 = new Student(3, "Prashad");

		sl.add(s3);
		sl.add(s1);
		sl.add(s2);
		
		System.out.println("Student List ::");

		System.out.println("Sort By Id -> ");
		Collections.sort(sl, new SortById());

		System.out.println("\t\tID\tName");

		for (Student st : sl) {
			System.out.println("\t\t"+st.getId() + "\t" + st.getName());
		}

		System.out.println("Sort By Name -> ");
		Collections.sort(sl, new SortByName());

		System.out.println("\t\tID\tName");

		for (Student st : sl) {
			System.out.println("\t\t"+st.getId() + "\t" + st.getName());
		}

	}

}
