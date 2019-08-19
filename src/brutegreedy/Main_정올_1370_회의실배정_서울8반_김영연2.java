package brutegreedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_정올_1370_회의실배정_서울8반_김영연2 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		
		int[][] m = new int[N][3];
		for(int i=0; i<N; i++) {
			m[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		}
		Arrays.sort(m, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
		List<int[]> list = new ArrayList<int[]>();
		list.add(m[0]);
		for(int i=1; i<m.length; i++) {
			if(list.get(list.size()-1)[2] <= m[i][1]) {
				list.add(m[i]);
			}
		}
		System.out.println(list.size());
		for(int[] meet:list) System.out.println(meet[0] + " ");
		sc.close();
	}

}
