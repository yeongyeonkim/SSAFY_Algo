package D3;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_5431_민석이의과제체크하기_서울8반_김영연
{
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("res/input_d1_2046.txt"));
		Scanner sc = new Scanner(System.in);
		int Testcase = sc.nextInt();

		for(int T=1; T<=Testcase; T++) {
			int n = sc.nextInt(); // 수강생의 수
			int k = sc.nextInt(); // 과제 제출한 사람 수
			int[] index_list = new int[n+1]; // 0으로 되어있음
			int[] submit_list = new int[k]; //요소 입력받기.
			
			for(int i=0; i<k; i++) {
				submit_list[i] = sc.nextInt();
				index_list[submit_list[i]]++;
			}
			System.out.print("#"+T+" ");
			for(int i=1; i<=n; i++) {
				if(index_list[i] == 0)
					System.out.print(i+" ");
			}
			System.out.println();		
		}
	}
}