package test;

public class Product {
	private int title;
	private String name;
	private int price;
	private int stock;

	public int getTitle() { return title; }
	public String getName() { return name; }
	public int getPrice() {	return price; }
	public int getStock() { return stock; }

	public void setPrice(int price) {
		this.price = price;
	}
	public Product() {}
	public Product(int title, String name, int price, int stock) {
		this.title = title;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("제품번호 : ")
			   .append(title + "\t|")
			   .append("제품이름 : ")
			   .append(name + "\t|")
			   .append("가격: ")
			   .append(price + "\t|")
			   .append("제품수량 : ")
			   .append(stock);
		return builder.toString();
	}	
}