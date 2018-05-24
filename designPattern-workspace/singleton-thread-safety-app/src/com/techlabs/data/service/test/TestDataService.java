package com.techlabs.data.service.test;

import com.techlabs.data.service.DataService;

public class TestDataService {

	public static void main(String[] args) {
		
		Thread t1=new Thread(new Runnable() {
			@Override
			public void run() {
				DataService service1 = DataService.getInstance();
				service1.doProcessing();
			}
		});
		
		Thread t2=new Thread(new Runnable() {
			@Override
			public void run() {
				DataService service2 = DataService.getInstance();
				service2.doProcessing();
			}
		});
		
		t1.start();
		t2.start();

	}

}
