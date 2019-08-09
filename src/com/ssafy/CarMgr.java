package com.ssafy;

import java.util.Arrays;

public class CarMgr {
	private Car[] cars = new Car[100];
	private int index;
	
	//객체를 딱 하나 만드는 싱글톤?패턴?
	//2. 
	private static CarMgr instance = new CarMgr();
	//1.
	private CarMgr() {}
	//3.
	public static CarMgr getInstance() {
		if(instance==null)instance = new CarMgr();
		return instance;
	}
	
	public void add(Car c) {
//		Car car = search(c.getNum());
//		if(car == null) 
		cars[index++] = c;
	}
	public Car[] search() {//오버로딩
//		Car[] tmp = new Car[index];
//		for(int i=0; i<index; i++) tmp[i] = cars[i];
//		System.arraycopy(cars, 0, tmp, 0, index);
//		System.out.println(Arrays.toString(tmp));
//		return tmp;
		return Arrays.copyOf(cars, index);	
	}
	public Car search(String num) {
		for(int i=0; i<index; i++) {
			Car c = cars[i];
			String nm = c.getNum();
			if(nm.equals(num)) return c;
		}
		return null;
	}
	public Car[] search(int price) {
		int idx = 0;
		for(int i=0; i<index; i++) {
			Car c = cars[i];
			if(c.getPrice() < price)
				idx++;
		}
		Car[] tmp = new Car[idx];
		idx = 0;
		for(int i=0; i<index; i++) {
			Car c = cars[i];
			if(c.getPrice() < price)
				tmp[idx++] = c;
		}
		return tmp;
	}
	public void update(String num, int price) {
		Car c = search(num);
		if(c != null) c.setPrice(price);
	}
	public void delete(String num) {
		Car c = search(num);
		if(c !=null) {
			for(int i=0; i<index; i++) {
				Car ca = cars[i];
				String nm = ca.getNum();
				if(nm.equals(num)) {
					//정렬
					for(int j=i; j<index-1; j++) {
						cars[j] = cars[j+1];
					}
					cars[--index] = null;
//					index--;
//					cars[i] = cars[index];
//					cars[index] = null;
				}
			}			
		}
//		for(int i=0; i<index; i++) {
//			Car ca = cars[i];
//			String nm=ca.getNum();
//			if(nm.equals(num)) {
//				index--;
//				cars[i]=cars[index];
//				cars[index]=null;
//				return;
//			}
//		}
	}
	public int size() {
		return index;
	}
	public int totalPrice() {
		int tot=0;
		for(int i=0; i<index; i++) {
			Car c = cars[i];
			tot=tot+c.getPrice();
		}
		return tot;
	}


}
