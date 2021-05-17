package test;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

public class Nothing {
	
	private double weight;
	private double height;
	
	public Nothing(double weight,double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void printBMI() {
		InnerNothing inner = new InnerNothing();
		double bmi = inner.calcBMI();
		System.out.println(bmi);
	}
	
	private class InnerNothing{
		public double calcBMI() {
			return weight/(height*height);
		}
	}

	
	
}
