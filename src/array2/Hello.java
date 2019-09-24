package array2;

public class Hello {
	public static double nCr(int n, int r) {
		if(r==0) return 1.0;
		return 1.0*n/r*nCr(n-1,r-1);
	}
//	public static double nCr(int n, int r) {
//		if(r==0 ) return 1.0;
//		if(n<r)return 0.0;
//		return nCr(n-1,r-1)+nCr(n-1,r);
//	} // 확률?
	public static void main(String[] args) {

	}
}