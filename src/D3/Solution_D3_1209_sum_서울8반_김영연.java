package D3;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_1209_sum_서울8반_김영연
{
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("res/sum.txt"));
		int[][] list = new int[100][100];
		Scanner sc = new Scanner(System.in);
		int row, col, diag1 = 0, diag2 = 0;
		for(int t=1; t<=10; t++) {
			int tcs = sc.nextInt(); // 쓰레기 값.
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					list[i][j] = sc.nextInt();
				}
			}
			int max = 0;
			for(int i=0; i<100; i++) {
				row = 0;
				col = 0;
				diag1 = 0;
				diag2 = 0;
				for(int j=0; j<100; j++) {
					row += list[i][j];
					col += list[j][i];
					if(row > max) max = row;
					if(col > max) max = col;
					if(i==j) {
						diag1 += list[i][j];
						if(diag1 > max) max = diag1;
					}
					if((i+j) == 99) {
						diag2 += list[i][j];
						if(diag2 > max) max = diag2;
					}
				}	
			}
			System.out.println("#"+t+" "+max);
		}		
	}
}