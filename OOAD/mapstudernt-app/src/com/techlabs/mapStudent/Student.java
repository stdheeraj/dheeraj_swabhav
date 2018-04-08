package com.techlabs.mapStudent;


public class Student implements Comparable<Student> {
	
	private int rollno;
	private String name;
	private int standard;
	
	public Student(int rollno, String name, int standard) {
		this.rollno=rollno;
		this.name=name;
		this.standard=standard;
	}
	
	public int getRollno() {
		return rollno;
	}
	
	public String getName() {
		return name;
	}
	
	public int getStandard() {
		return standard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rollno;
		result = prime * result + standard;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (rollno != other.rollno)
			return false;
		if (standard != other.standard)
			return false;
		return true;
	}

	@Override
	public int compareTo(Student s) {
		return this.rollno-s.rollno;
	}
	


}
