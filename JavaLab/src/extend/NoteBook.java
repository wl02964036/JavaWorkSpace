package extend;

public class NoteBook extends Product {
	
	public int warranty;
	
	public NoteBook(String name, int price, int warranty) {
		this.name = name;
//		setName(name);
		this.price = price;
//		setPrice(price);
		
		this.warranty = warranty;
	}
	
	@Override//annotation//表示方法是繼承來的
	public String desc() {
		
		return String.format("名稱:%s,價錢:%d,保固:%d天", name,price,warranty);
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
	

}
