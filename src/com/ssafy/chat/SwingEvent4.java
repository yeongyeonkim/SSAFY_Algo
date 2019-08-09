package com.ssafy.chat;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEvent4 {
	private JFrame f;
	private JButton b;

	public SwingEvent4() {// 생성자에서 객체 생성
		f = new JFrame("SwingGui");
		b = new JButton("OK");
	}

	private void addEvent() {
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
				b.setBackground(Color.GREEN);
				f.getContentPane().setBackground(Color.ORANGE);
				System.out.println(e.getActionCommand() + " " + b.getText());
			}
		});
	}

	private void display() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.YELLOW);
		f.setLayout(new FlowLayout());
		f.add(b);

		f.setSize(300, 300);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		SwingEvent4 gui = new SwingEvent4();
		gui.display();
		gui.addEvent();
	}

}
