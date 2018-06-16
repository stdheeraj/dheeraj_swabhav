package com.techlabs.thread.test;

import java.awt.EventQueue;

import com.techlabs.thread.ThreadFrame;

public class TestThreadFrame {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadFrame frame = new ThreadFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
