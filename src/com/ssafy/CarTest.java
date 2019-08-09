package com.ssafy;

public class CarTest {

	public static void main(String[] args) {
		CarMgr m = CarMgr.getInstance();

		m.add(new Car("111", "소나타", 3000));
		m.add(new Bus("112", "아반떼", 2000, 4));
		m.add(new Truck("113", "엑센트", 1000, 1.0));

		Car c = m.search("113");
		//Car car = new Truck("113", "엑센트", 1000, 1.0);
		
		System.out.println(c);
		System.out.println();

		Car[] cars = m.search();
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}
		System.out.println();

		m.update("113", 1111);

		cars = m.search(2500);
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}
		System.out.println();

		m.delete("112");
		cars = m.search();
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}
		System.out.println();

		System.out.println("등록차량수: " + m.size());
		System.out.println("차량총가격: " + m.totalPrice());
	}
}