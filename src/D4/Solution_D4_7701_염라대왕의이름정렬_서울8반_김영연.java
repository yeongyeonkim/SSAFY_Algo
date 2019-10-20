package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution_D4_7701_염라대왕의이름정렬_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> arr = new ArrayList<>();
			for(int i=0; i<n; i++) arr.add(br.readLine());
			Collections.sort(arr, new Comparator<String>(){
				@Override
				public int compare(String o1, String o2) {
					if(o1.length() > o2.length()) return 1;
					else if(o1.length() < o2.length()) return -1;
					else return o1.compareTo(o2);
				}
			});
			for(int i=0; i<arr.size() - 1; i++) {
				if(arr.get(i).equals(arr.get(i+1))) {
					arr.remove(i);
					i--;
				}
			}
			System.out.println("#"+t);
			for(String a : arr) System.out.println(a);
		}
	}
}