package com.techlabs.shape;

public class ShapeCreator {

	private IShape circle;
	private IShape rectangle;
	private IShape square;

	public ShapeCreator() {
		circle = new Circle();
		rectangle = new Rectangle();
		square = new Square();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}

}
