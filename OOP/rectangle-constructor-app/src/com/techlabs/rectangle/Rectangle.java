package com.techlabs.rectangle;

public class Rectangle {
	private int width;
	private int hieght;
	private BorderStyleOption border;

	public Rectangle(int width, int hieght, BorderStyleOption border) {
		this.width = width;
		this.hieght = hieght;
		this.border = border;
	}

	public Rectangle(int width, int hieght) {
		this(width, hieght, BorderStyleOption.SINGLE);
	}

	public int getWidth() {
		return width;
	}

	public int getHieght() {
		return hieght;
	}

	public BorderStyleOption getBorder() {
		return border;
	}

	public int calcArea() {
		return width * hieght;
	}

}
