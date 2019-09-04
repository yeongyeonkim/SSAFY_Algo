package D4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_3124_최소스패닝트리_Prim_서울8반_김영연 {

	static int[][] graph;
	static int V;
	static int[] w;
	static boolean[] v;
	
	private static long prim() {
		
		v[1] = true;
		for(int k=1; k<V; k++) {
			int minWeight = 1000000;
			int minVertax = 0;
			for(int i=1; i<=V; i++) {
				if(!v[i]) continue;
				for(int j=1; j<=V; j++) {
					if(v[j]) continue;
					if(graph[i][j]<minWeight && graph[i][j]!=0) {
						minWeight = graph[i][j];
						minVertax = j;
					}
				}
			}
			w[minVertax] = minWeight;
			v[minVertax] = true;
		}
		
		long sum = 0;
		for(int i=1; i<=V; i++) sum += w[i];
		return sum;
	}

	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		int a=0,b=0,c=0;
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			graph = new int[V+1][V+1];
			w = new int[V+1];
			v = new boolean[V+1];
			int E = Integer.parseInt(st.nextToken());
		
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				graph[a][b] = graph[b][a] = c; 
			}
			
			System.out.println("#" + tc + " " + prim());
		}
		br.close();
	}

}