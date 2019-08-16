package D4;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D4_5432_쇠막대기자르기_서울8반_김영연
{
	public static void main(String args[]) throws Exception
	{;
		System.setIn(new FileInputStream("res/stackstick.txt"));
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		sc.nextLine();
		for(int t=1; t<=testcase; t++) {
			int max = 0;
			int sum = 0;
			int flag = 0;
			String s = sc.nextLine();
			for(int i=0; i<s.length(); i++) {
				if(s.charAt(i) == '(') {
					max++;
					flag = 0;
				}
				else if(s.charAt(i) == ')'){
					max--;
						if(flag == 0) 
							sum += max;
						else
							sum++;
					flag = 1;
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}
}