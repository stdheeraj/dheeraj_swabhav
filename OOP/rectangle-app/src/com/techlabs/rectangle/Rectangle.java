package com.techlabs.rectangle;

import java.io.Serializable;

public class Rectangle implements Serializable {

	private int width;
	private int hieght;

	public void setWidth(int pwidth) {
		width = validateRange(pwidth);
	}

	public int getWidth() {
		return width;
	}

	public void setHieght(int phieght) {
		hieght = validateRange(phieght);
	}

	public int getHieght() {
		return hieght;
	}

	public int calculateArea() {
		return width * hieght;
	}
	
	private int validateRange(int para) {
		if (para < 10)
			return 10;
		else if (para > 100)
			return 100;
		else
			return para;
	}
}