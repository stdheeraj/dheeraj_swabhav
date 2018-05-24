package com.techlabs.data.service.test;

import com.techlabs.data.service.DataService;

public class TestDataService {

	public static void main(String[] args) {
		DataService service1 = DataService.getInstance();
		DataService service2 = DataService.getInstance();

		service1.doProcessing();
		service2.doProcessing();
	}

}
