package D5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution_D5_1256_K번째접미어_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		for(int t=1; t<=testcase; t++) {
			int k = Integer.parseInt(br.readLine());
			String str = br.readLine();
			ArrayList<String> arr = new ArrayList<>();
			for(int i=0; i<str.length(); i++) 
				arr.add(str.substring(i,str.length()));
			Collections.sort(arr);
			System.out.println("#"+t+" "+arr.get(k-1));
		}
	}

}
