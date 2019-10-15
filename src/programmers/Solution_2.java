package programmers;

public class Solution_2 {
	static int l, max, n;
	static String Num;
	static boolean[] visit;
	
	public static void perm(int count, char[] c) {
		if(count == l) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<c.length; i++) {
				if(c[i] != '\0')
					sb.append(c[i]);
			}
			int asd = Integer.parseInt(sb.toString());
			max = (max > asd) ? max : asd;
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visit[i]) {
				for(int j=0; j<=i; j++) 
				visit[j] = true;
				c[count] = Num.charAt(i);
				perm(count + 1, c);
				for(int j=0; j<=i; j++) 
				visit[j] = false;
			}
		}
	}
	
	public String solution(String number, int k) {
		Num = number;
		n = number.length();
		l = number.length() - k;
		visit = new boolean[number.length()];
		char[] c = new char[n];
		perm(0, c);
		
		String answer = max + "";
		return answer;
	}

}
