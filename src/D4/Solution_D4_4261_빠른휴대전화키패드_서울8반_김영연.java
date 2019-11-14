package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_4261_빠른휴대전화키패드_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			String[] key_pad = {null, null,"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
			int result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int k=0; k<n; k++) {
				String tmp = st.nextToken();
				int cnt = 0;
				if(tmp.length() != str.length()) continue;
				for(int i=0; i<tmp.length(); i++) { //주어진 단어
					boolean flag = false;
					char c = tmp.charAt(i); //단어 판별
					for(int j=0; j<str.length(); j++) { //번호를 다 보면서 그게 가능한 숫자인지 판별
						int index = str.charAt(j) - '0';
						for(int l=0; l<key_pad[index].length(); l++) {
							if(c == key_pad[index].charAt(l)) flag = true;
						}
						if(flag)break;
					}
					if(flag) cnt++;
				}
				if(cnt == str.length()) result++;
			}
			System.out.println("#"+t+" "+result);
		}
	}

}
