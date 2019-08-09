package test;

import java.util.ArrayList;

public class ProductTest {
	public static void main(String[] args) {
		ProductMgrlmpl mgr = ProductMgrlmpl.getInstance();
		// 상품정보를 저장
		mgr.add(new TV(12345, "LED고해상도TV", 3200000, 1, 100));
		mgr.add(new TV(12346, "삼성전자QN65", 1890000, 2, 65));
		mgr.add(new TV(12347, "UN65LS003", 4200000, 3, 75));
		mgr.add(new Refrigerator(4321, "삼성냉장고", 2200000, 4, 800));
		mgr.add(new Refrigerator(4320, "LG냉장고", 1200000, 5, 700));

		System.out.println("-------상품정보로 전체를 검색하는 기능-------");
		ArrayList<Product> arr = mgr.findall();
		for (Product s : arr)
			System.out.println(s);

		System.out.println("-------상품번호로 상품을 검색-------");
		Product p = mgr.findbytitle(12345);
		System.out.println(p);
		System.out.println("-------상품명으로 상품 검색-------");
		arr = mgr.findByName("냉장고");
		if (arr == null)
			System.out.println("찾을 수 없습니다.");
		else {
			for (Product s : arr)
				System.out.println(s);
		}
		System.out.println("-------tv 정보만 검색-------");
		if (mgr.findTV() == null)
			System.out.println("찾을 수 없습니다.");
		else {
			for (Product s : mgr.findTV())
				System.out.println(s);
		}
		System.out.println("-------냉장고만 검색-------");
		if (mgr.findRef() == null)
			System.out.println("찾을 수 없습니다.");
		else {
			for(Product s : mgr.findRef())
				System.out.println(s);
		}
		System.out.println("-------400L이상의냉장고검색-------");
		if(mgr.findLiter() == null)
			System.out.println("찾을 수 없습니다.");
		else {
			for(Product s : mgr.findLiter())
				System.out.println(s);
		}
		System.out.println("-------50inch 이상의 TV 검색-------");
		if(mgr.findinch() == null)
			System.out.println("찾을 수 없습니다.");
		else {
			for(Product s : mgr.findinch())
				System.out.println(s);
		}
		System.out.println("-------상품 번호와 가격을 입력받아 상품가격을 변경-------");
		System.out.println("**변경전**");
		for (Product s : mgr.findall())
			System.out.println(s);
		mgr.change(12345, 2600000);
		System.out.println("**변경후**");
		for (Product s : mgr.findall())
			System.out.println(s);
		
		System.out.println("-------상품번호로 상품을 삭제하는 기능-------");
		System.out.println("**변경전**");
		for (Product s : mgr.findall())
			System.out.println(s);
		mgr.deleteByType(12346);
		System.out.println("**변경후**");
		for (Product s : mgr.findall())
			System.out.println(s);
		
		System.out.println("-------전체 재고 상품 금액을 구하는 기능-------");
		System.out.println("전체 재고 상품 금액: " + mgr.allprice()+"원");
	}
}