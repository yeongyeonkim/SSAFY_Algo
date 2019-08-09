package queue;

import java.io.*;
import java.util.*;

public class BFS {
	public static int V;
	public static int E;
	public static int[][] graph;
	public static boolean[] visit;
	public static Queue<Integer> queue;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_bfs.txt"));
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E=sc.nextInt();
		graph = new int[V][V];
		visit = new boolean[V];
		queue = new LinkedList<Integer>();
		
		for(int i=0; i<E; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			graph[v1][v2] = graph[v2][v1] = 1;
		}
//		for(int[] a : graph) System.out.println(Arrays.toString(a));
		bfs(0);
		visit = new boolean[V];
	}
	public static void bfs(int node) {
		visit = new boolean[V];
		queue.offer(node);
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			if(visit[curr] == false) {
				visit[curr] = true;
				System.out.print(curr + " ");
				for(int next = 0; next < V; next++) {
					if(visit[next] == false && graph[curr][next] == 1) {
						queue.offer(next);
					}
				}
			}
		}
	}
}
