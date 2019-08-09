package stack2;

import java.util.Arrays;

public class QuickSort {
	public static int[] a = { 69, 19, 40, 2, 16, 8, 31, 22 };

	public static int partition(int begin, int end) {
		int pivot = (begin + end) / 2;
		int L = begin;
		int R = end;
		while (L < R) {
			while (a[L] < a[pivot] && L < R)
				L++;
			while (a[R] >= a[pivot] && L < R)
				R--;
			if (L < R) {
				if(L==pivot) pivot = R; //이해.
				int T = a[L];
				a[L] = a[R];
				a[R] = T;
			}
		}
		int T = a[pivot];
		a[pivot] = a[R];
		a[R] = T;
		return R;
	}

	public static void quicksort(int begin, int end) {
		System.out.println(Arrays.toString(a));
		if (begin < end) {
			int pivot = partition(begin, end);
			quicksort(begin, pivot - 1);
			quicksort(pivot + 1, end);
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(a));

		quicksort(0, a.length - 1);

		System.out.println(Arrays.toString(a));
	}

}
