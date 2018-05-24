package com.techlabs.data.service;

public enum DataService {
	
	BUCKET;
	
	public void doProcessing(){
		System.out.println(this.hashCode()+" is processing on data service");
	}

}
