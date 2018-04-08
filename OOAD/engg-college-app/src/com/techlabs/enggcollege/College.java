package com.techlabs.enggcollege;

import java.util.ArrayList;
import java.util.List;

public class College {

	private List<Professor> professors;
	private List<Student> students;

	public College() {
		professors = new ArrayList<Professor>();
		students = new ArrayList<Student>();
	}

	public void addProfessor(Professor professor) {
		this.professors.add(professor);
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public Iterable<Professor> getProfessors() {
		return this.professors;
	}

	public Iterable<Student> getStudents() {
		return this.students;
	}

}
