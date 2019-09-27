package tree;

import java.io.FileInputStream;
import java.util.Scanner;

public class TreeArray2 {

	public static int N;
	public static char[] a;

	public static void inorder(int i) {
		if (i <= N && a[i] != 0) {
			inorder(2 * i);
			System.out.print(a[i]);
			inorder(2 * i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/Inorder.txt"));
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(sc.nextLine());
			a = new char[N + 1];
			for(int i=1; i<= N; i++) {
				String[] sa = sc.nextLine().split(" ");
				a[i] = sa[1].charAt(0);
			}
			System.out.print("#"+tc+" ");
			inorder(1);
			System.out.println();
		}
		sc.close();
	}

}
