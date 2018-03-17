package com.techlabs.hashset.test;

import java.util.HashSet;
import java.util.Iterator;

import com.techlabs.hashset.Book;

class TestBook {

	public static void main(String[] args) {
		HashSet<Book> hs = new HashSet<Book>();

		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan",
				"Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);

		hs.add(b1);
		hs.add(b2);
		hs.add(b3);
		hs.add(b3);
		//hs.add(null);

		System.out.println("List of books added::");
		for (Book b : hs) {
			System.out.println(b.getId() + " " + b.getName() + " "
					+ b.getAuthor() + " " + b.getPublisher() + " "
					+ b.getQuantity());
		}
		
		System.out.println("\nDeleting '"+b1.getName()+"' book from list ...");
		hs.remove(b1);
		System.out.println("After deleting ...");
		System.out.println("List of books ::");
		Iterator<Book> iterator = hs.iterator();
		while(iterator.hasNext()) {
			Book b = (Book) iterator.next();
			System.out.println(b.getId() + " " + b.getName() + " "
					+ b.getAuthor() + " " + b.getPublisher() + " "
					+ b.getQuantity());
		}
		
		System.out.println("\nUpdating '"+b2.getName()+"' Book quantity");
		hs.remove(b2);
		b2.setQuantity(6);
		hs.add(b2);
		System.out.println("Updated List of books::");
		for (Book b : hs)
			System.out.println(b.getId() + " " + b.getName() + " "
					+ b.getAuthor() + " " + b.getPublisher() + " "
					+ b.getQuantity());
	}
}
