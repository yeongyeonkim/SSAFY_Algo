package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_5014_스타트링크_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> q = new LinkedList<>();
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		boolean[] number = new boolean[1000001];
		int count = 0;
		q.offer(new int[] {S, count}); // 시작점, count
		if(S == G) {System.out.println(count); return;}
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[0] + U == G || tmp[0] - D == G) { //목표지점 도달하면
				System.out.println(tmp[1] + 1);
				return;
			}
			if(number[tmp[0]] == true)
				continue;
			else number[tmp[0]] = true;
			//tmp[0] + u한게 넘으면 그친구는 offer안함
			//tmp[0] - d한게 작으면 그친구는 offer안함
			//끝났을때 number[G] = true면 count출력 / 아니면 use the stairs
			if(tmp[0] + U <= F && number[tmp[0] + U] == false)
				q.offer(new int[] {tmp[0]+U, tmp[1] + 1});
			if(tmp[0] - D >= 1 && number[tmp[0] - D] == false)
				q.offer(new int[] {tmp[0]-D, tmp[1] + 1});
		}
		System.out.println("use the stairs");
	}
}