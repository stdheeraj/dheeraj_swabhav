package com.techlabs.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomeFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn;
	private JLabel wishMessage;

	public WelcomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(2, 1));
		
		btn = new JButton("Wish");
		contentPane.add(btn);
		
		wishMessage = new JLabel();
		contentPane.add(wishMessage);
		btn.addActionListener(this);
		
		setContentPane(contentPane);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		wishMessage.setHorizontalAlignment(JLabel.CENTER);
		wishMessage.setText("Welcome to Mumbai...");

	}

}
