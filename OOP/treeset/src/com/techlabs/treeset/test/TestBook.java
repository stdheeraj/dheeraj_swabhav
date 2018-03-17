package com.techlabs.treeset.test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import com.techlabs.treeset.Book;

public class TestBook {

	public static void main(String[] args) {
		Set<Book> ts = new TreeSet<Book>();

		Book b1 = new Book(121, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(233, "Operating System", "Galvin", "Wiley", 6);
		Book b3 = new Book(101, "Data Communications & Networking", "Forouzan",
				"Mc Graw Hill", 4);

		ts.add(b1);
		ts.add(b2);
		ts.add(b3);
		ts.add(b3);
		
		System.out.println("List of books added::");
		for (Book b : ts) {
			System.out.println(b.getId() + " " + b.getName() + " "
					+ b.getAuthor() + " " + b.getPublisher() + " "
					+ b.getQuantity());
		}
		
		System.out.println("\nDeleting '"+b1.getName()+"' book from list ...");
		ts.remove(b1);
		System.out.println("After deleting ...");
		System.out.println("List of books ::");
		Iterator<Book> iterator = ts.iterator();
		while(iterator.hasNext()) {
			Book b = (Book) iterator.next();
			System.out.println(b.getId() + " " + b.getName() + " "
					+ b.getAuthor() + " " + b.getPublisher() + " "
					+ b.getQuantity());
		}
		
		System.out.println("\nUpdating '"+b2.getName()+"' Book quantity");
		ts.remove(b2);
		b2.setQuantity(6);
		ts.add(b2);
		System.out.println("Updated List of books::");
		for (Book b : ts)
			System.out.println(b.getId() + " " + b.getName() + " "
					+ b.getAuthor() + " " + b.getPublisher() + " "
					+ b.getQuantity());

			

	}

}
