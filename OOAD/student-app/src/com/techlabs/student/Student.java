package com.techlabs.student;

public class Student implements Comparable<Student> {

	private int rollno;
	private String name;

	public Student(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	public int getRollNo() {
		return this.rollno;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Student s) {
		return this.rollno - s.rollno;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		final Student s = (Student) obj;
		if (this.rollno != s.rollno)
			return false;

		if ((this.name == null) ? (s.name != null) : !this.name.equals(s.name))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		int hash = this.rollno;
		return hash;
	}
}