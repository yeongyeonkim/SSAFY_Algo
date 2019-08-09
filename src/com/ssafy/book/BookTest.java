package com.ssafy.book;

import java.util.List;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {
		BookMgrImpl mgr = BookMgrImpl.getInstance();
		Scanner sc = new Scanner(System.in);
		List<Book> tmp;

//		mgr.load();

		boolean flag = true;
		while (flag) {
			System.out.println("<<Book 매니저>>");
			System.out.println("1. 상품등록");
			System.out.println("2. 상품번호로 검색");
			System.out.println("3. 400");
			System.out.println("4. 50");
			System.out.println("종료는 0입력");
			int n = sc.nextInt();
			switch (n) {	
			case 1:
				try {
					String s1 = sc.next();
					String s2 = sc.next();
					int n1 = sc.nextInt();
					int n2 = sc.nextInt();
					mgr.add(new Book(s1, s2, n1, n2));
				} catch (Exception e) {
					System.out.println(e);
				}
			case 0: 
				flag = false;
				break;
			
			}

			System.out.println();
		}

	}

}
