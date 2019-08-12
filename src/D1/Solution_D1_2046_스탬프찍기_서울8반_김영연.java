package D1;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D1_2046_스탬프찍기_서울8반_김영연
{
	public static void main(String args[]) throws Exception
	{
//		System.setIn(new FileInputStream("res/input_d1_2046.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int count = 0;
		
		for(int i=1; i<=T; i++) {
			String bit = new String();
			bit = sc.nextLine();

			if(bit.charAt(0) == '1')
				count++;
			
			for(int k=0; k< bit.length() - 1; k++) {
				if(bit.charAt(k) == bit.charAt(k+1)) {
					continue;
				}
				else
				{
					count++;					
				}
			}
			System.out.println("#" + T + " " + count);
		}
		
	}
}