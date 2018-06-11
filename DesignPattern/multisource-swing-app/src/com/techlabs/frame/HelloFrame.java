package com.techlabs.frame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HelloFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton helloBtn, exitBtn;
	private JLabel helloMessage;

	public HelloFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

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

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		if (btn.getText().equals("Hello"))
			helloMessage.setText("Hello World...");
		else
			dispose();
	}

}
