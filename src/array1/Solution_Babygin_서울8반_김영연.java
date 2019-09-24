package array1;

import java.util.Random;
import java.util.Scanner;

public class Solution_Babygin_서울8반_김영연 {
	public static void main(String[] args) {
//		System.setIn(new FileInputStream("res/input_babygin.txt"));
		int[] number = new int[10];
		int cnt = 0;
		
		for(int i=0; i<6; i++) {
			int r = (int)(Math.random()*10);
			number[r]++;	
		}
		//---------출력을 보기위한 영역--------
		for(int i=0; i<=9; i++) {
			System.out.print(number[i]+" ");
		}
		System.out.println(" ");
		//-------------------------------
		for(int i=0; i<=7; i++) {
			if(number[i] == 0) // 값이 0인 경우 
				continue;
			else if(number[i]/3 >= 1) { // 값이 3이상인 경우
				cnt++;
				number[i] %= 3;
				i--; //다시 앞전으로 돌아감. 
			}
			else { // 1이나 2인 경우
				if(number[i] >= 1 && number[i+1] >=1 && number[i+2] >= 1) {
					cnt++;
					number[i]--;
					number[i+1]--;
					number[i+2]--;
					i--;
				}
				else { // 규칙이 파괴되는 경우
					System.out.println("baby-gin이 아닙니다.");
					break;
				}
			}
		}
		if(cnt >= 2)
			System.out.println("baby-gin입니다!!");
	}
}