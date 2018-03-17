package com.techlabs.hashset.test;

import java.util.HashSet;

import com.techlabs.hashset.Book;

class TestBook {

	public static void main(String[] args) {
		HashSet<Book> set = new HashSet<Book>();

		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan",
				"Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);

		set.add(b1);
		set.add(b2);
		set.add(b3);

		for (Book b : set) {
			System.out.println(b.getId() + " " + b.getName() + " "
					+ b.getAuthor() + " " + b.getPublisher() + " "
					+ b.getQuantity());
		}
	}
}
