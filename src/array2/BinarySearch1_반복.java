package array2;

public class BinarySearch1_반복 {
	
	public static int[] a = {2, 4, 7, 9, 11, 19, 23};
	
	public static boolean binarySearch(int[] a, int key) {
		int start = 0;
		int end = a.length - 1;
		
		while(start <= end) {
			int middle = (start+end)/2;
			if(a[middle] == key) {
				return true;
			}
			else if(a[middle] > key) {
				end = middle - 1;
			}
			else
				start = middle + 1;
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(binarySearch(a,7));
		System.out.println(binarySearch(a,20));
	}
}