package com.techlabs.treeset;

public class Book implements Comparable<Book> {
	private int id, quantity;
	private String name, author, publisher;

	public Book(int id, String name, String author, String publisher,
			int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int compareTo(Book b) {
		if (getId() > b.getId())
			return 1;
		else if (getId() < b.getId())
			return -1;
		else
			return 0;

	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
}