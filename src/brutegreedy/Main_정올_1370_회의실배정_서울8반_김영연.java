package brutegreedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_정올_1370_회의실배정_서울8반_김영연 {

	public static class Meeting implements Comparable<Meeting>{

		private int num;
		private int start;
		private int end;
		
		public Meeting(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) {
			return Integer.compare(end, o.end); //오름차순.
		}
		public String toString() {
			return num + "(" + start + ":" + end + ")";
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		Meeting[] m = new Meeting[N];
		for(int i=0; i<N; i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(m);
		
		List<Meeting> list = new ArrayList<Meeting>();
		list.add(m[0]);
		for(int i=1; i<m.length; i++) {
			if(list.get(list.size() - 1).end <= m[i].start) {
				list.add(m[i]);
			}
		}
	}

}
