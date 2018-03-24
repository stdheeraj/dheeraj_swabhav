package com.techlabs.interfacepolymorphism.test;

import com.techlabs.interfacepolymorphism.Boy;
import com.techlabs.interfacepolymorphism.IEmotionable;
import com.techlabs.interfacepolymorphism.IMemorable;
import com.techlabs.interfacepolymorphism.Man;

public class TestInterfacePolymorphism {

	public static void main(String[] args) {
		
		Man x=new Man();
		Boy y=new Boy();
		
		atTheParty(x);
		atTheCinema(y);
		
		atTheParty(y);
	//	atTheCinema(x);

	}
	
	private static void atTheParty(IMemorable im){
		System.out.println("At the party");
		im.wish();
		im.departy();
	}
	
	private static void atTheCinema(IEmotionable ie){
		System.out.println("At the cinema");
		ie.cry();
		ie.laugh();
	}

}
