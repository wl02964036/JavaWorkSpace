package func;

public class TestPeople {

	public static void main(String[] args) {
		People p = new People();//32
		System.out.println("過重BMI = "+People.overWeightBMI);
		
		double bmi = People.BMI(1.7, 70);
		System.out.println("Static BMI = " +bmi);

		
		System.out.println(Math.pow(2, 5));
		
		System.out.println(String.join("-" , "a" , "Hello" , "World"));
	}

}
