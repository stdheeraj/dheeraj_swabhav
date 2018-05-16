package com.techlabs.emp.data.analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDataLoader implements IDataLoader {

	private String filepath;

	public FileDataLoader(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public List<String> load() throws IOException {

		List<String> datalist = new ArrayList<String>();

		File data = new File(filepath);
		BufferedReader br = new BufferedReader(new FileReader(data));

		String stringLine;
		while ((stringLine = br.readLine()) != null)
			datalist.add(stringLine);
		
		br.close();
		return datalist;
	}

}
