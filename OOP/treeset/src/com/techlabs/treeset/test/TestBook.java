package com.techlabs.treeset.test;

import java.util.Set;
import java.util.TreeSet;

import com.techlabs.treeset.Book;

public class TestBook {

	public static void main(String[] args) {
		Set<Book> set = new TreeSet<Book>();

		Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(101, "Data Communications & Networking", "Forouzan",
				"Mc Graw Hill", 4);

		set.add(b1);
		set.add(b2);
		set.add(b3);

		for (Book b : set)
			System.out.println(b.getId() + " " + b.getName() + " "
					+ b.getAuthor() + " " + b.getPublisher() + " "
					+ b.getQuantity());

	}

}
