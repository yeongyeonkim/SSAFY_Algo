package stack2;

import java.util.Arrays;
import java.util.Scanner;

//순열 조합을 20~25번째의 줄로 바꿔주면됨. 
//중복은 v[]를 해주면 검사되고. 순열과 조합의 구분은 for문의 i로(0 or start) 
public class PermComb {

	public static int n, r, cnt;
	public static int[] d = { 1, 2, 3, 4, 5 };
	public static int[] a, v;

	public static void permcomb(int start, int count) {
		if (count == r) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for (int i = start; i < n; i++) {	//
			if (v[i] == 0) {				//
				v[i] = 1;					//
				a[count] = d[i];
				permcomb(i, count + 1);
				v[i] = 0;					//
			}
		}
	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		n=sc.nextInt();
//		r=sc.nextInt();
		n = 5;
		r = 3;

		v = new int[n];
		a = new int[r];
		permcomb(0, 0);

		System.out.println(cnt);
	}
}