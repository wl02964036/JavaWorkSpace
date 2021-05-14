package extend;
//ctrl+1:fix
//public abstract class NoteBook extends Product {
public class NoteBook extends Product {
//	@Override
//	public void calc() {
//		
//	}
	
	public int warranty;
	
	public NoteBook(String name, int price, int warranty) {
//		super();//如果沒有主動呼叫super(name,price);，compiler會自動加一個在這裡
		super(name,price);
//		setName(name);
//		setPrice(price);
//		this.name = name;//被super(name,price);取代
//		this.price = price;//被super(name,price);取代
		
		this.warranty = warranty;
	}
	
	@Override//annotation//表示方法是繼承來的
	public String desc() {
		String info = super.desc();//名稱:%s,價錢:%d
		return String.format("%s,保固:%d天", info ,warranty);
	}

	public int getWarranty() {
		return warranty;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}


		

	
	

}
