package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_백준_1157_단어공부_서울8반_김영연 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] alphabet = new int[26];
		int max = 0;
		int max_cnt = 0;
		int max_index = 0;
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c < 91) alphabet[c-65]++;
			else alphabet[c-97]++;
		}
		for(int i=0; i<26; i++) 
			max = max > alphabet[i] ? max : alphabet[i];
		for(int i=0; i<26; i++) {
			if(alphabet[i] == max) {
				max_index = i;
				max_cnt++;
			}
		}
		if(max_cnt > 1) System.out.println("?");
		else System.out.println((char)(max_index + 'A'));
	}
}