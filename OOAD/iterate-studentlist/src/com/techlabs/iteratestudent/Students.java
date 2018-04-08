package com.techlabs.iteratestudent;

import java.util.Iterator;

public class Students implements Iterable<String> {

	private String[] sl;

	public String[] getStudentList() {
		return sl;
	}

	public Students(int capacity) {
		sl = new String[capacity];
	}

	public void add(int pos, String name) {

		if (pos >= sl.length || pos < 0)
			throw new ArrayIndexOutOfBoundsException();
		sl[pos] = name;
	}

	@Override
	public Iterator<String> iterator() {
		return new StudentIterator(this);
	}
}