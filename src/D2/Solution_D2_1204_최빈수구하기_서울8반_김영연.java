package D2;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D2_1204_최빈수구하기_서울8반_김영연
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for(int t=1; t<=T; t++) {
			int garbage=sc.nextInt();
			int[] number = new int[101];
			for(int i=0; i<1000; i++) {
				int index = sc.nextInt();
				number[index]++;
				}
			int max_index = 0;	
			int max = -435;
			for(int i=0; i<=100; i++) {
				if(number[i] >= max) {
					max = number[i];
					max_index = i;
					}
				}
			System.out.println("#"+t+" "+max_index);
		}
	}
}