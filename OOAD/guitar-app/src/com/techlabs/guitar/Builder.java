package com.techlabs.guitar;

public enum Builder {
	FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, ANY;

	public String toString() {
		switch (this) {
		case FENDER:
			return "Fender";
		case MARTIN:
			return "Martin";
		case GIBSON:
			return "Gibson";
		default:
			return "";
		}
	}
}