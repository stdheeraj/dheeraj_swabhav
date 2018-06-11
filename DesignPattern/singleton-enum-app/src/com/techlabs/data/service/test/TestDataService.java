package com.techlabs.data.service.test;

import com.techlabs.data.service.DataService;

public class TestDataService {

	public static void main(String[] args) {
		
		DataService service1=DataService.BUCKET;
		DataService service2=DataService.BUCKET;
		
		service1.doProcessing();
		service2.doProcessing();
	}

}
