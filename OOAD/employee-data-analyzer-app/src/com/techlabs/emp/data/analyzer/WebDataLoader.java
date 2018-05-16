package com.techlabs.emp.data.analyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class WebDataLoader implements IDataLoader {

	private String urlpath;

	public WebDataLoader(String urlpath) {
		this.urlpath = urlpath;
	}

	@Override
	public List<String> load() throws IOException {

		List<String> datalist = new ArrayList<String>();

		URL data = new URL(urlpath);
		URLConnection urlcon = data.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				urlcon.getInputStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			datalist.add(inputLine);

		in.close();

		return datalist;
	}

}
