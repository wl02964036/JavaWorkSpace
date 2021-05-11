package encap;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Car {
	
	private String model;//null
	private int price;//0
	private char color;//''
	
	//Constructor
	public Car(char c ) {
//		color = c;
		this("Yaris", c);//呼叫另一個建構方法
	}
	
	public Car(String model, char color) {
		this.model = model;
		this.color = color;
	}

/*	
	public Car(String model,char color) {
//		this.model = model;
		setModel(model);
		this.color = color;
	}
*/

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
		if (model.equals("Yaris")) {
			this.price = 575000;
		} else if (model.equals("Prius")) {
			this.price = 1090000;
		} else {
			System.out.println("Error:型號錯誤");
		}
	}
	

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}


	public int getPrice() {
		return price;
	}

}
