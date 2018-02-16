package com.techlabs.circle;

public class Circle {

	private float radius;
	private float PI = 3.14f;
	private String color = "Red";

	public void setRadius(float pradius) {
		radius = pradius;
	}

	public void setColor(String pcolor) {
		if (pcolor.equalsIgnoreCase("red") || pcolor.equalsIgnoreCase("blue")
				|| pcolor.equalsIgnoreCase("green"))
			color = pcolor;
	}

	public float getRadius() {
		return radius;
	}

	public String getColor() {
		return color;
	}

	public float calArea() {
		return PI * radius * radius;
	}

}
