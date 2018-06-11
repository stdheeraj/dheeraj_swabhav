package com.techlabs.frame.test;

import java.awt.EventQueue;

import com.techlabs.frame.HelloFrame;

public class TestHelloFrame {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloFrame frame = new HelloFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
