package com.techlabs.linkedhashset.test;

import java.util.Iterator;
import java.util.LinkedHashSet;

import com.techlabs.linkedhashset.Book;

public class TestBook {

	public static void main(String[] args) {
		LinkedHashSet<Book> lhs = new LinkedHashSet<Book>();
		
		Book b1 = new Book(101, "Let us C", "Yashwant Kanetkar", "BPB", 8);
		Book b2 = new Book(102, "Data Communications & Networking", "Forouzan",
				"Mc Graw Hill", 4);
		Book b3 = new Book(103, "Operating System", "Galvin", "Wiley", 6);
		
		lhs.add(b1);
		lhs.add(b2);
		lhs.add(b3);
		lhs.add(b3);
		//lhs.add(null);

				System.out.println("List of books added::");
				for (Book b : lhs) {
					System.out.println(b.getId() + " " + b.getName() + " "
							+ b.getAuthor() + " " + b.getPublisher() + " "
							+ b.getQuantity());
				}
				
				System.out.println("\nDeleting '"+b1.getName()+"' book from list ...");
				lhs.remove(b1);
				System.out.println("After deleting ...");
				System.out.println("List of books ::");
				Iterator<Book> iterator = lhs.iterator();
				while(iterator.hasNext()) {
					Book b = (Book) iterator.next();
					System.out.println(b.getId() + " " + b.getName() + " "
							+ b.getAuthor() + " " + b.getPublisher() + " "
							+ b.getQuantity());
				}
				
				System.out.println("\nUpdating '"+b2.getName()+"' Book quantity");
				lhs.remove(b2);
				b2.setQuantity(6);
				lhs.add(b2);
				System.out.println("Updated List of books::");
				for (Book b : lhs)
					System.out.println(b.getId() + " " + b.getName() + " "
							+ b.getAuthor() + " " + b.getPublisher() + " "
							+ b.getQuantity());
		
	}

}
