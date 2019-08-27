package D4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D4_1231_중위순회_서울8반_김영연 {
	static String[] Tree;
	static int n;

	public static void dfs(int v) {
		if (v * 2 <= n && Tree[v * 2] != null)
				dfs(v * 2);
		System.out.print(Tree[v]);
		if (v * 2 + 1 <= n && Tree[v * 2 + 1] != null)
				dfs(v * 2 + 1);
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/Inorder.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			n = Integer.parseInt(br.readLine());
			Tree = new String[n + 1];
			for (int i = 1; i <= n; i++) {
				String[] s = br.readLine().split(" ");
				Tree[i] = s[1];
			}
			System.out.print("#"+t+" ");
			dfs(1);
			System.out.println();
		}
	}
}
