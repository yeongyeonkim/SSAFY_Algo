package com.ssafy;

public class Car {
    private String num;
    private String model;
    private int price;

    public Car(){
    	this(null,null,0);
    }

	public Car(String num, String model, int price){
		//super(); 숨어있음.
		setNum(num);
		setModel(model);
		setPrice(price);
    }


	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(getNum())
    	.append("\t")
    	.append(getModel())
    	.append("\t")
    	.append(getPrice());
    	
    	return sb.toString();
    }

}
