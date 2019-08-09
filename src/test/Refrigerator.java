package test;

public class Refrigerator extends Product {
	private int Liter;

	public Refrigerator() { super(); }
	
	
	
	public Refrigerator(int title, String name, int price, int stock, int Liter) {
		super(title, name, price, stock);
		this.Liter = Liter;
	}



	public int getLiter() {
		return Liter;
	}

	public String toString() {
		return super.toString() + "\t|" + Liter + "리터";
	}
	
}
