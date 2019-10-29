package D1;

import java.util.Scanner;

public class Solution_D1_2056_연월일달력_서울8반_김영연 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			String str = sc.next();
			int year = Integer.parseInt(str.substring(0, 4));
			int month = Integer.parseInt(str.substring(4, 6));
			int day = Integer.parseInt(str.substring(6, 8));
			boolean flag = false;
			if(month < 1 || 12 < month) flag = true;
			if(month == 2 && (1>day||day>28)) flag = true;
			if(month != 2) {
				if(1<=month && month <=7) {
					if(month % 2 == 0 && (1>day || day > 30)) flag = true;
					if(month % 2 == 1 && (1>day || day > 31)) flag = true;
				} else {
					if(month % 2 == 1 && (1>day || day > 30)) flag = true;
					if(month % 2 == 2 && (1>day || day > 31)) flag = true;
				}
			}
			if(!flag) System.out.printf("#%d %04d/%02d/%02d\n", t, year, month, day);
			else System.out.println("#"+t+" -1");
		}
	}
}