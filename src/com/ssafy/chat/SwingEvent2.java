package com.ssafy.chat;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEvent2 implements ActionListener {
	private JFrame f;
	private JButton b;

	public SwingEvent2() {// 생성자에서 객체 생성
		f = new JFrame("SwingGui");
		b = new JButton("OK");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		b.setBackground(Color.GREEN);
		System.out.println(e.getActionCommand() + " " + b.getText());
	}

	private void addEvent() {
		b.addActionListener(this);
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
		SwingEvent2 gui = new SwingEvent2();
		gui.display();
		gui.addEvent();
	}

}
