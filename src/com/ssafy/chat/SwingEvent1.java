package com.ssafy.chat;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingEvent1 {
	private JFrame f;
	private JButton b;

	public SwingEvent1() {// 생성자에서 객체 생성
		f = new JFrame("SwingGui");
		b = new JButton("OK");
	}

	class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			f.getContentPane().setBackground(Color.GREEN);
			b.setBackground(Color.GREEN);
			System.out.println(e.getActionCommand() + " " + b.getText());
		}

	}

	private void addEvent() {
		ActionListener al = new ButtonHandler();
		b.addActionListener(al);
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
		SwingEvent1 gui = new SwingEvent1();
		gui.display();
		gui.addEvent();
	}

}
