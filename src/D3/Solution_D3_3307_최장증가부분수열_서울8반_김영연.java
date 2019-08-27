package D3;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_3307_최장증가부분수열_서울8반_김영연
{
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("res/input_d1_2046.txt"));
		Scanner sc = new Scanner(System.in);

		int TestCase = sc.nextInt();
		sc.nextLine();
		for(int g=1; g<=TestCase; g++) {
			int N = sc.nextInt();
			int[] list = new int[N];
			int[] dp = new int[N];
			
			for(int k=0; k<N; k++)
			{
				list[k] = sc.nextInt();
				dp[k] = 1;
			}
			int max = 0;
			
			for(int i=1; i<N; i++) {
				for(int j=i-1; j>=0; j--) {
					if(list[i] > list[j] && dp[j] >= dp[i])
						dp[i] = dp[j] + 1;
				}
			}
			for(int i=0; i<N; i++) {
				if(max < dp[i])
					max = dp[i];
			}
			System.out.println("#"+g+" "+max);
		}
	}
}