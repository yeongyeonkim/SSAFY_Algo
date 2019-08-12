package D1;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D1_2063_중간값찾기_서울8반_김영연
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] array = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = sc.nextInt();
		}
		for(int i=0; i<N-1; i++) {
			for(int j=N-1; j>i; j--) {
				if(array[i] > array[j]) {
					int tmp = array[i];
					array[i]= array[j];
					array[j] = tmp;
				}
			}
		}
		System.out.println(array[N/2]);
	}
}