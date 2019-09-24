package array2;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation2 {

	public static int n, r, caseCount, data[];
	//flag 는 0번자리 사용 유무.
	// permutation에선 start 안쓴다.
	public static void permutation(int start, int flag, int count) {
		if (count == r) {
			caseCount++;
			System.out.println(Arrays.toString(data));
			return;
		}
		for (int i = start; i <= n; i++) {
			data[count] = i;
			if ((flag & 1 << i) == 0) { // 사용되고 있지 않느냐?
				data[count] = i;
				permutation(i, flag|1<<i , count + 1);
				//flag|1 << i 는 반대로 1이된다.
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		data = new int[r];
		permutation(1, 0, 0);
		System.out.println(caseCount);
		sc.close();
	}

}
