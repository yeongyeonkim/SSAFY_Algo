package D3;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution_D3_5607_조합_서울8반_김영연 {
	
	static BigInteger nCr(int n, int r, int p) {
		long[] fac = new long[n+1];
		fac[0] = 1;
		for(int i=1; i<=n; i++) fac[i] = fac[i-1]*i%p;
		BigInteger P = BigInteger.valueOf(p);
		BigInteger A = BigInteger.valueOf(fac[n]);
		BigInteger B = BigInteger.valueOf(fac[r]).modInverse(P).remainder(P);
		BigInteger C = BigInteger.valueOf(fac[n-r]).modInverse(P).remainder(P);
		return A.multiply(B).multiply(C).remainder(P);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			int p = 1234567891;
			System.out.println("#"+t+" "+nCr(n,r,p));
		}

	}

}
