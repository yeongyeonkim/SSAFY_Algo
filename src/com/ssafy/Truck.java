package com.ssafy;

public class Truck extends Car {
	private double ton;

	public Truck() {
		this(null, null, 0, 0);
	}

	public Truck(String num, String model, int price, double ton) {
		super(num, model, price);
		setTon(ton);
	}

	public double getTon() {
		return ton;
	}

	public void setTon(double ton) {
		this.ton = ton;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\t")
		  .append(getTon());
		return sb.toString();
	}
	
}
