package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_괄호추가하기 {

	static int n, max;
	static int[] operation;
	static char[] operator;
	
	public static int cal(int a, char oper, int b) {
		switch(oper) {
		case '+': return a + b;
		case '-': return a - b;
		case '*': return a * b;
		}
		return 0;
	}
	public static void dfs(int count, int sum) {
		if(count >= n/2) {
			max = Math.max(max, sum);
			return;
		}
		dfs(count + 1, cal(sum, operator[count], operation[count+1]));
		if(count + 2 <= n/2) {
			dfs(count + 2, cal(sum, operator[count],
					cal(operation[count + 1], operator[count + 1], operation[count + 2])));
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		operation = new int[n/2 + 1];
		operator = new char[n/2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int idx1 = 0, idx2 = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*') 
				operator[idx1++] = str.charAt(i);
			else operation[idx2++] = Integer.parseInt(str.charAt(i) + "");
		}
		max = Integer.MIN_VALUE;
		dfs(0, operation[0]);
		System.out.println(max);
	}
}