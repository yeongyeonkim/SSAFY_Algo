package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기_서울8반_김영연 {

	static int min, max, n;
	static int[] operator;

	public static void cal(int a[], int count, int result) {
		if (count == n-1) {
			max = (max > result) ? max : result;
			min = (min < result) ? min : result;
			return;
		}
		//+
		if(operator[0] >= 1) {
			operator[0]--;
			cal(a, count + 1, result + a[count + 1]);
			operator[0]++;
		}
		//-
		if(operator[1] >= 1) {
			operator[1]--;
			cal(a, count + 1, result - a[count + 1]);
			operator[1]++;
		}
		//x
		if(operator[2] >= 1) {
			operator[2]--;
			cal(a, count + 1, result * a[count + 1]);
			operator[2]++;
		}
		//%
		if(operator[3] >= 1) {
			operator[3]--;
			if(result < 0) { //음수라면
				int tmp = Math.abs(result);
				tmp /= a[count + 1];
				tmp -= tmp * 2;
				cal(a, count + 1, tmp);
			}
			else 
				cal(a, count + 1, result / a[count + 1]);
			operator[3]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++)
			list[i] = Integer.parseInt(st.nextToken());
		operator = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		cal(list, 0, list[0]);
		System.out.println(max);
		System.out.println(min);
	}
}