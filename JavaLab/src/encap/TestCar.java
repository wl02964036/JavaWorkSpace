package encap;

public class TestCar {

	public static void main(String[] args) {
		
		Car c = new Car("Yaris",'Y');
//		c.setodel = "Prius";
//		c.setModel("Yaris");
//		c.price = 1000000;
		
		
		System.out.printf("型號:%s,價格:%7d,顏色:%c",c.getModel(),c.getPrice(),c.getColor());

	}

}
