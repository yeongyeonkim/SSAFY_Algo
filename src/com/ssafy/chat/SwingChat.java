package com.ssafy.chat;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingChat {
	private JFrame f;
	private JTextArea ta;
	private JScrollPane sp;
	private JTextField tf;
	private JPanel p;
	private JButton s;
	private JButton e;

	public SwingChat() {// 생성자에서 객체 생성

		f = new JFrame("SwingChat");
		ta = new JTextArea("서버전송 성공!!\n");
		sp = new JScrollPane(ta);
		tf = new JTextField();
		p = new JPanel();
		s = new JButton("Send");
		e = new JButton("Exit");
	}

	private void addEvent() {
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append(tf.getText()+"\n");
				ta.setCaretPosition(ta.getDocument().getLength());
				tf.setText("");
				tf.requestFocus();
			}
		};
		tf.addActionListener(al); //엔터
		s.addActionListener(al);
		e.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
//				System.exit(0);
			}
		});
	}

	private void display() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = f.getContentPane();
		
		ta.setEditable(false);
		cp.add(sp, "Center");
		
		p.setLayout(new GridLayout(10,1));
		p.add(s);
		p.add(e);
		cp.add(p, "East");
		cp.add(tf,"South");

		f.setSize(500, 400);
		f.setVisible(true);
		tf.requestFocus();
	}

	public static void main(String[] args) {
		SwingChat gui = new SwingChat();
		gui.display();
		gui.addEvent();
	}

}
