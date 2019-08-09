package test;

import java.util.ArrayList;

public class ProductMgrlmpl implements IProductMgr {

	private ArrayList<Product> p;

	private static ProductMgrlmpl instance;

	private ProductMgrlmpl() {
		p = new ArrayList<Product>();
	}

	public static ProductMgrlmpl getInstance() {
		if (instance == null)
			instance = new ProductMgrlmpl();
		return instance;
	}

	public void add(Product pro) {
		p.add(pro);
	}

	public ArrayList<Product> findall() {
		return p;
	}

	public Product findbytitle(int title) {
		for (Product s : p) {
			if (s.getTitle() == title)
				return s;
		}
		return null;
	}

	public ArrayList<Product> findByName(String name) {
		ArrayList<Product> tmp_list = new ArrayList<Product>();
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getName().contains(name)) {
				tmp_list.add(p.get(i));
			}
		}
		if (!tmp_list.isEmpty())
			return tmp_list;
		else
			return null;
	}

	public ArrayList<Product> findTV() {
		ArrayList<Product> tmp_list = new ArrayList<Product>();
		for (Product s : p) {
			if (s instanceof TV)
				tmp_list.add(s);
		}
		if (!tmp_list.isEmpty())
			return tmp_list;
		else
			return null;
	}

	public ArrayList<Product> findRef() {

		ArrayList<Product> tmp_list = new ArrayList<Product>();
		for (Product s : p) {
			if (s instanceof Refrigerator)
				tmp_list.add(s);
		}
		if (!tmp_list.isEmpty())
			return tmp_list;
		else
			return null;
	}
	public ArrayList<Product> findLiter() {
		ArrayList<Product> tmp_list = new ArrayList<Product>();
		for(Product s : p) {
			if(s instanceof Refrigerator && ((Refrigerator) s).getLiter() >= 400) {
				tmp_list.add(s);
			}
		}
		if(!tmp_list.isEmpty())
			return tmp_list;
		else
			return null;
	}

	public ArrayList<Product> findinch() {
		ArrayList<Product> tmp_list = new ArrayList<Product>();
		for(Product s : p) {
			if(s instanceof TV && ((TV) s).getInch() >= 50)
				tmp_list.add(s);
		}
		if(!tmp_list.isEmpty())
			return tmp_list;
		else
			return null;
	}

	public void change(int title, int price) {
		Product s = findbytitle(title);
		s.setPrice(price);
	}

	public void deleteByType(int title) {
		for(int i=0; i<p.size(); i++) {
			if(p.get(i).getTitle() == title) {
				p.remove(i);
				return;
			}
		}
	}

	public int allprice() {
		int sum = 0;
		for(Product s : p)
			sum += s.getPrice() * s.getStock();
		return sum;
	}

}
