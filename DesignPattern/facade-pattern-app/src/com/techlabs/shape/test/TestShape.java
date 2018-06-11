package com.techlabs.shape.test;

import com.techlabs.shape.ShapeCreator;

public class TestShape {

	public static void main(String[] args) {
		ShapeCreator shapeMaker = new ShapeCreator();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}

}
