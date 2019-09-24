package array2;

import java.util.Arrays;

public class PermutationLoop {

	public static void main(String[] args) {
		int[] data = { 1, 2, 3 };
//		Random r = new Random();
//		for(int i=0; i<data.length; i++) {
//			data[i] = r.nextInt(10);
//		}
		System.out.println(Arrays.toString(data));
		int cnt = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i] != data[j]) {
					for (int k = 0; k < data.length; k++) {
						if (data[k] != data[i] && data[k] != data[j]) {
							System.out.println("" + data[i] + data[j] + data[k]);
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
