package com.techlabs.linkedhashset;

public class Book {
	private int id;
	private String name;
	private String author;
	private String publisher;
	private int quantity;

	public Book(int id, String name, String author, String publisher,
			int quantity) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getAuthor() {
		return author;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
}