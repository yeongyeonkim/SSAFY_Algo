package D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution_D3_3376_파도반수열_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		ArrayList<Long> arr = new ArrayList<>();
		arr.add((long) 1);
		arr.add((long) 1);
		arr.add((long) 1);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			int size = Integer.parseInt(br.readLine());
			while(arr.size() <= size)
				arr.add(arr.get(arr.size() - 2) + arr.get(arr.size() - 3));
			System.out.println("#"+t+" "+arr.get(size - 1));
		}
	}
}