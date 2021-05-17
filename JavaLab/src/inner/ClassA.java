package inner;

public class ClassA {
	private double weight;
	private double height;

	public ClassA(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}

	public void printBMI() {
		InnerClass inner = new InnerClass();
//		inner.calcBMI();
		double bmi = inner.calcBMI();//alt+shift+l
		System.out.println(bmi);
	}

	private class InnerClass {
		public double calcBMI() {
			return weight / (height * height);
		}
	}

}
