package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
리스트에 처리되지 않은 중요도가 높은 요소가 있다면
무조건 맨 뒤 순서로 가고
중요도가 가장 높은 녀석일경우 처리해주는데
처리해주는 순서에서 location번째 녀석이 누구냐.(0번부터시작하는 location)
 */
public class Solution_4 {

	static boolean[] visit;
	
	public static int max(int[] list) {
		int m = Integer.MIN_VALUE;
		for(int i=0; i<list.length; i++) {
			if(!visit[i]) 
				m = m > list[i] ? m : list[i];
		}
		return m;
	}
	public static void main(String[] args) {
		int[] list = {2,1,3,2};
//		int[] list = {1,1,9,1,1,1};
		int location = 2;
//		int location = 0;
		int ans = -1; // 1 // 5
		
		int n = list.length;
		visit = new boolean[n];
		Queue<int[]> q = new LinkedList<>();
		for(int i=0; i<list.length; i++)
			q.add(new int[] {i,list[i]});
		ArrayList<Integer> arr = new ArrayList<>();
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[1] == max(list)) {
				visit[tmp[0]] = true;
				arr.add(tmp[0]);//인덱스를 기억
			}
			else 
				q.add(new int[] {tmp[0],tmp[1]});
		}
		for(int i=0; i<n; i++) {
			if(arr.get(i) == location) {
				System.out.println(i+1);
				return;
			}
		}
	}
}