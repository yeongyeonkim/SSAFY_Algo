package test;

public class TV extends Product{
	private int inch;

	public TV() {  }

	
	public TV(int title, String name, int price, int stock, int inch) {
		super(title, name, price, stock);
		this.inch = inch;
	}



	public int getInch() {	return inch; }
	
	public String toString() {
		return super.toString() + "\t|" + "인치: " + inch;
	}
}