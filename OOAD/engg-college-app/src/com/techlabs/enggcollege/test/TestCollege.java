package com.techlabs.enggcollege.test;

import com.techlabs.enggcollege.Branch;
import com.techlabs.enggcollege.College;
import com.techlabs.enggcollege.Professor;
import com.techlabs.enggcollege.Student;

public class TestCollege {

	public static void main(String[] args) {

		Professor professor = new Professor(101, "Andheri", "07/05/1987", 8);
		Student student = new Student(201, "Bandra", "17/09/1998", Branch.INFT);

		College vit = new College();

		vit.addProfessor(professor);
		vit.addStudent(student);

		System.out.println("Professor Details ->");
		System.out.println("ID\tAddress\tDOB\t\tSalary");
		for (Professor p : vit.getProfessors())
			System.out.println(p.getId() + "\t" + p.getAddress() + "\t"
					+ p.getDOB() + "\t" + p.calSalary() + "$");

		System.out.println("\nStudent Details ->");
		System.out.println("ID\tAddress\tDOB\t\tBranch");
		for (Student s : vit.getStudents())
			System.out.println(s.getId() + "\t" + s.getAddress() + "\t"
					+ s.getDOB() + "\t" + s.getBranch());

	}

}
