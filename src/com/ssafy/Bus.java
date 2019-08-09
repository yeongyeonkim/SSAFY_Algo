package com.ssafy;

public class Bus extends Car{
	private int seat;

	public Bus() {
		this(null, null, 0, 0);
	}
	
	public Bus(String num, String model, int price, int seat) {
		super(num, model, price);
		setSeat(seat);
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\t")
		  .append(getSeat());
		return sb.toString();
	}
}