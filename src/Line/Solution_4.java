import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] count = new int[n];
		int cnt = 0; //갱신을 위함 false라면 자리에있었음.
		int max = Integer.MIN_VALUE; // max값
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp == 1) {//사람이있으면
				count[i] = 0;
				cnt = 0;
			}
			else { //사람이없으면
				count[i] = ++cnt;
				max = max < count[i] ? count[i] : max; //max값 갱신
			}
		}
		max = (max % 2 == 0) ? (max / 2) : (max / 2 + 1);
		//짝수면 max / 2 홀수면 max/2  +1;
		System.out.println(max);
	}
}
