package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14891_톱니바퀴_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = new String[5];
		for (int i = 1; i <= 4; i++)
			str[i] = br.readLine();
		int k = Integer.parseInt(br.readLine());
		int[] top = new int[5];
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			boolean[] flag = new boolean[5];
			//왼쪽 탐색
			int tmp = number - 1;
			flag[number] = true;
			while(true) {
				if(tmp == 0 || !flag[tmp+1]) break;
				if (str[tmp].charAt((top[tmp] + 2) % 8) != str[tmp+1].charAt((top[tmp+1] + 6) % 8)) 
					flag[tmp] = true;
				tmp--;
			}
			//오른쪽 탐색
			tmp = number + 1;
			while (true) { // 우 탐색
				if (tmp == 5 || !flag[tmp-1]) break;
				if(str[tmp-1].charAt((top[tmp-1] + 2) % 8) != str[tmp].charAt((top[tmp] + 6) % 8)) 
					flag[tmp] = true;
				tmp++;
			}
			//이제 visit true인 녀석들을 갱신
			for(int j=1; j<=4; j++) {
				if(flag[j]) { 
					if(j % 2 == number % 2) { //같으면
						if (dir == 1) top[j] = top[j] - 1 < 0 ? 7 : top[j] - 1;
						else 		  top[j] = top[j] + 1 > 7 ? 0 : top[j] + 1;
					} else { 
						if (dir == 1) top[j] = top[j] + 1 > 7 ? 0 : top[j] + 1;
						else 		  top[j] = top[j] - 1 < 0 ? 7 : top[j] - 1;
					}
				}
			}
		}
		int sum = 0;
		if (str[1].charAt(top[1]) == '1') sum += 1;
		if (str[2].charAt(top[2]) == '1') sum += 2;
		if (str[3].charAt(top[3]) == '1') sum += 4;
		if (str[4].charAt(top[4]) == '1') sum += 8;
		System.out.println(sum);
	}
}