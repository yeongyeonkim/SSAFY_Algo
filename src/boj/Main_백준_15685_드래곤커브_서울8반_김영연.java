package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_백준_15685_드래곤커브_서울8반_김영연 {

	static boolean[][] visit;
	static ArrayList<Integer> dragon;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void make_dragon() { 
		//스택처럼 ArrayList의 요소들을 전체크기만큼 뒤에서부터 0인덱스까지 참조하며 
		//그값에 해당하는 값을 ArrayList에 add하는방식
		for(int g=1; g<=10; g++) { //g의 범위가 10까지이므로.
			int size = dragon.size();
			int index = size-1;
			for(int i=0; i<size; i++) { //사이즈만큼반복
				int num = dragon.get(index);
				num = num + 1 == 4 ? 0 : num + 1;
				dragon.add(num);				
				index--;
			}
		}
	}
	public static void move(int x, int y, int dir, int k) { //visit으로 점
		visit[x][y] = true;
		for(int i=0; i<k; i++) {
			int num = (dragon.get(i) + dir)%4;
			x += dx[num];
			y += dy[num];
			visit[x][y] = true;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		dragon = new ArrayList<>();
		dragon.add(0);
		make_dragon();
		visit = new boolean[101][101];
		int cnt = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int k = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
			move(x, y, dir, k);
		}
		for(int i=0; i<=99; i++) {
			for(int j=0; j<=99; j++) {
				if(visit[i][j] && visit[i+1][j] && visit[i][j+1] && visit[i+1][j+1]) cnt++;
			}
		}
		System.out.println(cnt);
	}
}