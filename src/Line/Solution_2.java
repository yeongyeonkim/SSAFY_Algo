import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2 {
	
	static boolean[] visit;
	static int[] arr;
	static int n, cnt;
	
	public static void perm(int[] p, int count) {
		if(count == n) {
			cnt--;
			if(cnt == 0) {
				for(int i=0; i<n; i++) 
					System.out.print(p[i]);
			}
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				p[count] = arr[i];
				perm(p, count + 1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] info = br.readLine().split(" ");
		cnt = Integer.parseInt(br.readLine());
		n = info.length;
		arr = new int[n];
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(info[i]);
		visit = new boolean[n];
		Arrays.sort(arr);
		int[] p = new int[n];
		perm(p, 0);
	}
}
