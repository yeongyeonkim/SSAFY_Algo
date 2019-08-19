package D3;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_1208_Flatten_서울8반_김영연
{
	public static void main(String args[]) throws Exception
	{;
		Scanner sc = new Scanner(System.in);
		int[] array = new int[100];
		for(int w=1; w<=10; w++) {
			int Dump = sc.nextInt();
			for(int v=0; v<100; v++) {
				array[v] = sc.nextInt();
			}
			//오름차순 정렬
			for(int i=array.length-1; i>=0; i--) {
				for(int j=0; j<i; j++) {
					if(array[i] < array[j]) {
						int tmp = array[j];
						array[j] = array[i];
						array[i] = tmp;
					}								
				}
			}
			//Dump 횟수만큼
			while(Dump > 0) {
				Dump--;
				int s=0, e=array.length-1;
				while(array[s] == array[s+1]) s++;
				while(array[e] == array[e-1]) e--;
				if(e - s == 1 && array[e] - array[s] == 1) {
					//2223 의 경우 인덱스값과 값의 차이가 1인경우에는 그저 멈춰주어야함.
					System.out.println("#"+w+" "+"1");
					break;
				}
				array[s]++;
				array[e]--;
			}
			System.out.println("#"+w+" "+(array[99] - array[0]));
		}
		
	}
}