package com.techlabs.movies.test;

import com.techlabs.movies.File;
import com.techlabs.movies.Folder;

public class TestMovies {
	
	public static void main(String[] args) {
		
		Folder rootMovie=new Folder("Movies");
		
		rootMovie.addItem(new File("ABCD", 500, "avi"));
		rootMovie.addItem(new File("PQR", 600, "avi"));
		
		Folder hindiMovie=new Folder("Hindi Movie");
		hindiMovie.addItem(new File("lmno", 400, "mp4"));
		rootMovie.addItem(hindiMovie);
		
		rootMovie.display();
		
	}

}
