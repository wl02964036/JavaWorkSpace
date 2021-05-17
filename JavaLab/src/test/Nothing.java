package test;

public class Nothing {

	String name;
	int price;
	public void setPrice(String name,int price) {
		this.name = name;
		this.price = price;
	}
	
	public Nothing() {
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String desc() {
		return String.format("名稱:%s,價錢:%d", name,price);
	}
	
}
