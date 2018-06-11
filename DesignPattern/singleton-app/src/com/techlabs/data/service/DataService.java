package com.techlabs.data.service;

public class DataService {
	
	private static DataService bucket;
	
	private DataService(){
		System.out.println("Data Service created.");
	}
	
	public static DataService getInstance(){
		if(bucket==null)
			bucket=new DataService();
		return bucket;
	}
	
	public void doProcessing(){
		System.out.println(this.hashCode()+" is processing on data service");
	}

}
