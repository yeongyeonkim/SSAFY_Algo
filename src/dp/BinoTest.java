package dp;

public class BinoTest {
	public static int bino(int n, int k) {
		if (k == 0 || n == k) return 1;
		else return bino(n - 1, k - 1) + bino(n - 1, k);
	}

	public static int[][] b;
	
	public static int bino1(int n, int r) {
		if(r == 0 || n == r) return 1;
		if(b[n][r] != 0) return b[n][r];
		b[n][r] = bino1(n-1, r-1) + bino1(n-1, r);
		return b[n][r];
	}
	
	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println(bino(n, k));
		b = new int[n+1][n+1];
		System.out.println(bino1(n,k));
	}
}