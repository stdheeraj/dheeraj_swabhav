package com.techlabs.emp.data.analyzer;

import java.io.IOException;
import java.util.List;

public interface IDataLoader {
	
	public List<String> load() throws IOException;

}
