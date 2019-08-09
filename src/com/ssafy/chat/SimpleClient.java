package com.ssafy.chat;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleClient {
	private JFrame f;
	private JTextArea ta;
	private JScrollPane sp;
	private JTextField tf;
	private JPanel p;
	private JButton s;
	private JButton e;

	private Socket so;
	private ObjectOutputStream oos;
	private BufferedReader br;
	private ClientThread ct;

	public SimpleClient() {
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
//				ta.append(tf.getText() + "\n");
//				ta.setCaretPosition(ta.getDocument().getLength());
				try {
					oos.writeObject(tf.getText());
					oos.flush();
					tf.setText("");
					tf.requestFocus();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		};
		tf.addActionListener(al); // 엔터
		s.addActionListener(al);
		e.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				f.dispose();
				ct.stopRun();
//				System.exit(0);
			}
		});
	}

	private void display() {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = f.getContentPane();

		ta.setEditable(false);
		cp.add(sp, "Center");

		p.setLayout(new GridLayout(10, 1));
		p.add(s);
		p.add(e);
		cp.add(p, "East");
		cp.add(tf, "South");

		f.setSize(500, 400);
		f.setVisible(true);
		tf.requestFocus();
	}

	class ClientThread extends Thread {
		private BufferedReader br;
		private boolean isRunning = true;

		public ClientThread(BufferedReader br) {
			this.br = br;
		}

		public void stopRun() {
			isRunning = false;
		}

		public void run() {
			String msg;
			try {
				while (isRunning) {
					msg = br.readLine();
					System.out.println();
					ta.append(msg + "\n");
					ta.setCaretPosition(ta.getDocument().getLength());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void connect() {
		try {
			so = new Socket("70.12.108.160", 8888);
			oos = new ObjectOutputStream(so.getOutputStream());
//			oos.writeObject("");
//			oos.flush();

			br = new BufferedReader(new InputStreamReader(so.getInputStream()));
//			String msg = br.readLine();
//			System.out.println();

			ct = new ClientThread(br);
			ct.start();

//			// 엔터로 전송.
//			ta.append(msg + "\n");
//			ta.setCaretPosition(ta.getDocument().getLength());
//			tf.setText("");
//			tf.requestFocus();

//			br.close();
//			oos.close();
//			so.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SimpleClient sc = new SimpleClient();
		sc.display();
		sc.addEvent();
		sc.connect();
	}

}
