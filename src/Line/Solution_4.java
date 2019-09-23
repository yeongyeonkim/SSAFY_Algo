import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//시험에서 낸 것의 반례를 발견하여, 정답이라고 생각하는 코드로 수정하였습니다.
public class Solution_4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] count = new int[n];
		int cnt = 0;
		int index = 0;
		int max = 0; // max값
		while (index < count.length) { //처음 사람발견 or 범위를 벗어나는경우
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp == 1) break;
			else {
				cnt++;
				index++;
			}
		}
		max = (max > cnt - 1) ? max : cnt - 1;
		cnt = 0;
		index++;
		//벗어난 경우엔 while에 안들어 갈 것이고, 그렇지 않으면 사람을 발견하러 들어감
		while (index < count.length) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp == 1) {
				// max값 갱신해주기.
				int tmp_max = (cnt % 2 == 0) ? (cnt / 2) : (cnt / 2 + 1);
				if (max < tmp_max) max = tmp_max;
				cnt = 0;
				index++;
			} else {
				cnt++; 
				index++;
			}
		}
		//벗어났을때의 cnt도 고려
		max = (max > cnt - 1) ? max : cnt - 1;
		System.out.println(max);
	}
}
