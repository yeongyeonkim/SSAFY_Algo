package com.ssafy.book;

import java.util.*;

public class BookComp {

	public static void main(String[] args) {
		
		List<Book> list = new ArrayList<Book>();
		list.add(new Book("111","홍길동전",1000,10));
		list.add(new Book("999","강호동전",9000,90));
		list.add(new Book("333","손오공전",1000,30));
		list.add(new Book("555","사오정전",1000,20));
		list.add(new Book("777","저팔계전",7000,30));
		for(Book b : list)
			System.out.println(b);
		
		Collections.sort(list);
		System.out.println();
		for(Book b : list)
			System.out.println(b);

		Collections.sort(list, new BookComparator());
		for(Book b : list)
			System.out.println(b);
		
		/*
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("손오공");
		list.add("강호동");
		list.add("사오정");
		list.add("저팔계");
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		*/
	}

}
