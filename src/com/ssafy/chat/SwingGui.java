package com.ssafy.chat;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingGui {
	private JFrame f;
	private JButton b;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	
	
	public SwingGui() {//생성자에서 객체 생성
		f = new JFrame("SwingGui");
		b = new JButton("OK");
		b2 = new JButton("b2");
		b3 = new JButton("b3");
		b4 = new JButton("b4");
		b5 = new JButton("b5");
	}
	
	public void display() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
/*		f.add(b);
		f.add(b2,BorderLayout);
		f.add(b3);
		f.add(b4);
		f.add(b5);
*/		
/*		f.setLayout(new GridLayout(3,2)); 
		f.add(b);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
*/
		//		FlowLayout
//		f.setLayout(new FlowLayout()); //생성된 순서대로 출력
//		f.add(b);
//		f.add(b2);
//		f.add(b3);
//		f.add(b4);
//		f.add(b5);
		
		f.setSize(300, 300);		
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingGui gui = new SwingGui();
		gui.display();
	}

}
