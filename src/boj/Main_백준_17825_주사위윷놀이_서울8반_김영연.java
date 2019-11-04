package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_17825_주사위윷놀이_서울8반_김영연 {
	
	static int max;
	static int[] number;
	
	static class Game {
		static class Node{
			int score;
			Node first;
			Node second;
			boolean isEmpty;
			
			public Node(int score) {
				this.score = score;
				this.first = null;
				this.second = null;
				this.isEmpty = true;
			}
		}
		static class Player{
			Node curr;
			int total_score;
			
			public Player(Node curr) {
				this.curr = curr;
				this.total_score = 0;
			}
		}
		Player[] player;
		Node start;
		
		public Game() {
			this.player = new Player[4];
			this.start = new Node(-1);
			for(int i=0; i<4; i++) this.player[i] = new Player(start);
			mapInit();
		}
		
		public void mapInit() {
			Node cur =  this.start;
			Node cur2 = null;
			Node cur3 = null;
			Node cur4 = null;
			Node cur5 = null;
			Node cur6 = null;
			for(int i=1; i<=20; i++) {
				cur.first = new Node(i*2);
				cur = cur.first;
				if(i==5) cur2 = cur;
				else if(i==10) cur3 = cur;
				else if(i==15) cur4 = cur;
				else if(i==20) cur5 = cur;
			}
			cur.first = new Node(0); // 40->0(도착점)으로가는 노드 설정
			//10->중간으로가는
			cur2.second = new Node(13);
			cur2 = cur2.second;
			cur2.first = new Node(16);
			cur2 = cur2.first;
			cur2.first = new Node(19);
			cur2 = cur2.first;
			cur2.first = new Node(25);
			cur2 = cur2.first;
			cur6 = cur2; // 중간점
			cur2.first = new Node(30);
			cur2 = cur2.first;
			cur2.first = new Node(35);
			cur2 = cur2.first;
			cur2.first = cur5; //40;
			
			//20->중간으로가는
			cur3.second = new Node(22);
			cur3 = cur3.second;
			cur3.first = new Node(24);
			cur3 = cur3.first;
			cur3.first = cur6;
			
			//30->중간으로가는
			cur4.second = new Node(28);
			cur4 = cur4.second;
			cur4.first = new Node(27);
			cur4 = cur4.first;
			cur4.first = new Node(26);
			cur4 = cur4.first;
			cur4.first = cur6;
		}
		
		public void move(int count) {
			if(count == 10) {
				int score = 0;
				for(int i=0; i<4; i++) score += player[i].total_score;
				max = Math.max(max, score);
				return;
			}
			for(int i=0; i<4; i++) {
				Player p = player[i];
				Node origin = p.curr;
				int jump = number[count] - 1; // 아래아래줄에서 다음으로 일단 한번 갈것이므로
				if(p.curr.score == 0) continue;
				//도착인경우 다음으로
				if(p.curr.second != null) p.curr = p.curr.second;
				else 					  p.curr = p.curr.first;
				//second 경로가있으면 거기로 무조건
				
				while(p.curr.score != 0 && jump-- >0) 
					p.curr = p.curr.first;
				
				//그점에 이미 누군가 있어서 이동할 수 없으면 다시돌아감 시작점으로
				if(!p.curr.isEmpty) { 
					p.curr = origin;
					continue;
				}
				p.total_score += p.curr.score;
				origin.isEmpty = true; //다른 말들이 올 수 있
				p.curr.isEmpty = (p.curr.score == 0) ? true : false;
				//마지막 지점인 경우만 제외하고 나머진 올 수 없게
				move(count + 1);
				p.curr.isEmpty = true;
				p.total_score -= p.curr.score;
				p.curr = origin;
				p.curr.isEmpty = false;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		number = new int[10];
		for(int i=0; i<10; i++) number[i] = Integer.parseInt(st.nextToken());
		Game game = new Game();
		max = 0;
		game.move(0);
		System.out.println(max);		
	}
}