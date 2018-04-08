package com.techlabs.mapStudent.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.techlabs.mapStudent.Student;

public class TestStudentMap {

	public static void main(String[] args) {
		
		Student s1=new Student(101, "A", 10);
		Student s2=new Student(101, "AA", 10);
		Student s3=new Student(102, "B", 10);
		
		Map<Student, Student> map = new HashMap<Student, Student>();
		//Map<Student, Student> map = new LinkedHashMap<Student, Student>();
		//Map<Student, Student> map = new TreeMap<Student, Student>();
		
		System.out.println("Adding ->");
		map.put(s1, s1);
		map.put(s2, s2);
		map.put(s3, s3);
		//System.out.println("Map size = "+map.size());
		System.out.println("\t\tRoll No\tName\tStd");
		for (Entry<Student, Student> entry : map.entrySet())
			System.out.println("\t\t"+entry.getValue().getRollno()+"\t"+entry.getValue().getName()+"\t"+entry.getValue().getStandard());
		
		System.out.println("Updating ->");
		map.replace(s2, new Student(103, "AA", 10));
		System.out.println("\t\tRoll No\tName\tStd");
		for (Entry<Student, Student> entry : map.entrySet())
			System.out.println("\t\t"+entry.getValue().getRollno()+"\t"+entry.getValue().getName()+"\t"+entry.getValue().getStandard());		
		
		System.out.println("Deleting ->");
		map.remove(s3);
		System.out.println("\t\tRoll No\tName\tStd");
		for (Entry<Student, Student> entry : map.entrySet())
			System.out.println("\t\t"+entry.getValue().getRollno()+"\t"+entry.getValue().getName()+"\t"+entry.getValue().getStandard());

	}

}
