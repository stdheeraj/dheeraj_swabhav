package com.techlabs.iteratestudent;

import java.util.Iterator;

class StudentIterator implements Iterator<String> {

	private Students s;
	private int count;

	StudentIterator(Students students) {
		this.s = students;
	}

	@Override
	public boolean hasNext() {
		if (count < s.getStudentList().length)
			return true;
		return false;
	}

	@Override
	public String next() {
		return s.getStudentList()[count++];
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}