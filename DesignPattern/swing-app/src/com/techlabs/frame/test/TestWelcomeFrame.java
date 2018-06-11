package com.techlabs.frame.test;

import java.awt.EventQueue;

import com.techlabs.frame.WelcomeFrame;

public class TestWelcomeFrame {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeFrame frame = new WelcomeFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
