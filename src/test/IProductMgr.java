package test;

import java.util.ArrayList;

public interface IProductMgr {
	
	//상품정보를 저장
	public void add(Product pro);
	
	//상품정보 전체를 검색
	public  ArrayList<Product> findall();
	
	//상품번호로 상품을 검색
	public Product findbytitle(int title);
	
	//상품명으로 상품 검색
	public ArrayList<Product> findByName(String name);

	// tv 정보만 검색
	public ArrayList<Product> findTV();

	//냉장고만 검색
	public ArrayList<Product> findRef();
	
	//400L 이상의 냉장고 검색
	public ArrayList<Product> findLiter();
	
	//50inch 이상의 TV 검색
	public ArrayList<Product> findinch();
	
	//상품 번호와 가격을 입력 받아 상품 가격을 변경할 수 있는 기능
	public void change(int title, int price);
	
	//상품 번호로 상품을 삭제하는 기능
	public void deleteByType(int title);
	
	//전체 재고 상품 금액을 구하는 기능.
	public int allprice();
}
