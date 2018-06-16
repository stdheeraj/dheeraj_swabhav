package com.techlabs.tic.tac.toe.game.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TicTacToeGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton helloBtn, exitBtn;
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	private JLabel helloMessage, playerNameLabel, playerName, mark, statusLabel, status;

	public TicTacToeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//startGame();
		setContentPane(startGame());
		contentPane.setVisible(true);
		
	}
	
	private void getUserData(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(2, 2));

		helloBtn = new JButton("Hello");
		helloBtn.addActionListener(this);

		exitBtn = new JButton("Exit");
		exitBtn.addActionListener(this);

		helloMessage = new JLabel();
		helloMessage.setHorizontalAlignment(JLabel.CENTER);

		contentPane.add(helloBtn);
		contentPane.add(exitBtn);
		contentPane.add(helloMessage);

		setContentPane(contentPane);
		setVisible(true);
	}
	
	private JPanel startGame(){
		//contentPane.removeAll();
		//contentPane.setVisible(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(5, 3));
		
		playerNameLabel = new JLabel("Current Player: ");
		playerName = new JLabel();
		
		mark = new JLabel();
		
	    
		btn1 = new JButton(" ");
		btn2 = new JButton(" ");
		btn3 = new JButton(" ");
		btn4 = new JButton(" ");
		btn5 = new JButton(" ");
		btn6 = new JButton(" ");
		btn7 = new JButton(" ");
		btn8 = new JButton(" ");
		btn9 = new JButton(" ");
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		
		statusLabel = new JLabel("Status: ");
		status = new JLabel();
		
		contentPane.add(playerNameLabel);
		contentPane.add(playerName);
		contentPane.add(mark);
		contentPane.add(btn1);
		contentPane.add(btn2);
		contentPane.add(btn3);
		contentPane.add(btn4);
		contentPane.add(btn5);
		contentPane.add(btn6);
		contentPane.add(btn7);
		contentPane.add(btn8);
		contentPane.add(btn9);
		contentPane.add(statusLabel);
		contentPane.add(status);
		return contentPane;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		if (btn.getText().equals("Hello"))
			helloMessage.setText("Hello World...");
		else
			dispose();
	}

}
