package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_D3_1244_최대상금_서울8반_김영연 {
	static char[] arr;

	public static void swap(int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static int findmax(int i) {
		char max = '0';
		int index = -1;
		for (int j = i; j < arr.length; j++) {
			if (arr[j] >= max) {
				max = arr[j];
				index = j;
			}
		}
		return index;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testcase; t++) {
			String[] info = br.readLine().split(" ");
			String str = info[0];
			int count = Integer.parseInt(info[1]);
			arr = new char[str.length()];

			char[] backup = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
				backup[i] = arr[i];
			}

			while (count != 0) {
				int flag = 0;
				for (int i = 0; i < arr.length; i++) {
					int max = findmax(i + 1);
					if (max == -1) {
						flag = 1;
						int cnt = 0;
						for (int j = 0; j < arr.length - 1; j++) {
							if (arr[j] > arr[j + 1])
								cnt++;
						}
						if (cnt == arr.length - 1)
							flag = 0;
						break;
					}
					if (arr[i] == arr[max])
						continue;
					if (arr[i] < arr[max]) {
						swap(i, max);
						flag = 1;// swap했다!
						break;
					}
				}
				if (flag == 0) // 스왑을 안했다면 맨뒤의 요소들 와리가리
					swap(arr.length - 1, arr.length - 2);
				count--;
			}
			for (int i = 0; i < arr.length; i++) {
				if (backup[i] != arr[i]) {
					for (int j = i + 1; j < arr.length; j++) {
						if (backup[i] == backup[j] && backup[j] != arr[j] && arr[i] < arr[j]) {
							swap(i, j);
						}
					}
				}
			}
			System.out.print("#" + t + " ");
			for (char c : arr)
				System.out.print(c);
			System.out.println();
		}
	}
}