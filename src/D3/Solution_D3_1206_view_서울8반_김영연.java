package D3;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_1206_view_서울8반_김영연
{
	static int cnt;
	static void test(int l2, int l1, int pivot, int r1, int r2) {
		if(l2 >= pivot || l1 >= pivot || r1 >= pivot || r2 >= pivot) {
			return;//주위 값이 하나라도 크거나 같게되면 종료.
		}
		else { //pivot이 주위 값보다 1이상 큼.			
			cnt++;
			test(l2, l1, pivot-1, r1, r2);
		}
	}
	public static void main(String args[]) throws Exception
	{;
	System.setIn(new FileInputStream("res/view.txt"));
		Scanner sc = new Scanner(System.in);
		int list[] = new int[5]; // 정렬한 값 받을 리스트		
		for(int t=1; t<=10; t++) {
			cnt = 0;
			int n = sc.nextInt();
			int view[] = new int[n]; // 건물 높이 리스트
			for(int i=0; i<n; i++) {
				view[i] = sc.nextInt();
			}
			for(int i=2; i<n-2; i++) {
				test(view[i-2], view[i-1], view[i], view[i+1], view[i+2]);
			}
			System.out.println("#"+t+" "+cnt);
		}
		
	}
}