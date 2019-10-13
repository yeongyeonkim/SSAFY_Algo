package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_정올_2247_도서관_서울8반_김영연 {
	
	static class library implements Comparable<library>{
		int start;
		int end;
		public library(int start, int end) {
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(library o) {
			return this.start - o.start;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<library> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr.add(new library(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(arr);
		int start = arr.get(0).start;
		int end = arr.get(0).end;
		int max_time = 0;
		int empty_time = 0;
		for(int i=1; i<arr.size(); i++) {
			if(end >= arr.get(i).start) {  //범위가 걸침. 갱신을 해주어야함.
				end = (end > arr.get(i).end) ? end : arr.get(i).end;
				max_time = (max_time > end - start) ? max_time : end - start;
			}
			else { //더 클 경우 지금까지의 start 엔드를 차이.=가장긴지확인
				max_time = (max_time > end - start) ? max_time : end - start;
				empty_time = (empty_time > arr.get(i).start - end) ? empty_time : arr.get(i).start - end;
				start = arr.get(i).start;
				end = (end > arr.get(i).end) ?  end : arr.get(i).end;
			}
		}
		System.out.println(max_time + " " + empty_time);
	}
}