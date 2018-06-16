package com.techlabs.thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ThreadFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton helloBtn, printBtn, asyncBtn;
	private DateTimeFormatter dtf;

	public ThreadFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
		printBtn = new JButton("Print Time");
		printBtn.setBounds(3, 48, 97, 49);
		printBtn.addActionListener(this);
		
		asyncBtn = new JButton("Print Time Asynchronously");
		asyncBtn.setBounds(130, 48, 177, 49);
		asyncBtn.addActionListener(this);
		
		helloBtn = new JButton("Hello");
		helloBtn.setBounds(334, 48, 97, 49);
		helloBtn.addActionListener(this);

		contentPane.add(printBtn);
		contentPane.add(asyncBtn);
		contentPane.add(helloBtn);

		setContentPane(contentPane);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();

		if (btn.getText().equals("Hello"))
			System.out.println("Hello World...");
		
		if (btn.getText().equals("Print Time")){
			while (true) {
				LocalDateTime now = LocalDateTime.now();
				System.out.println(dtf.format(now));
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
			
		
		if (btn.getText().equals("Print Time Asynchronously")){
			Thread t1=new Thread(new PrintAsyncThread());
			t1.start();
		}
	}

}
