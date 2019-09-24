package array2;

public class BinarySearch2_재귀 {

	public static boolean binarySearch(int[] a, int low, int high, int key) {
		if(low > high)
			return false;
		int middle = (low+high)/2;
		if(key == a[middle])
			return true;
		else if(key < a[middle])
			return binarySearch(a, low, middle-1, key);
		else
			return binarySearch(a, middle+1, high, key);
	}

	public static void main(String[] args) {
		int[] a = {2,4,7,9,11,19,23};		
		System.out.println(binarySearch(a, 0, 6, 7));
		System.out.println(binarySearch(a, 0, 6, 20));
	}
}