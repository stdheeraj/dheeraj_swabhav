package com.techlabs.linkedhashset.test;

import java.util.LinkedHashSet;

import com.techlabs.linkedhashset.Book;

public class TestBook {

	public static void main(String[] args) {
		LinkedHashSet<Book> hs = new LinkedHashSet<Book>();
		
		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan",
				"Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
		
		hs.add(b1);
		hs.add(b2);
		hs.add(b3);
		
		for (Book b : hs) {
			System.out.println(b.getId() + " " + b.getName() + " " + b.getAuthor() + " "
					+ b.getPublisher() + " " + b.getQuantity());
		}
	}

}
