package func;

public class TestVarargs {

	public static void main(String[] args) {

		int sum = add(1, 2, 3, 4, 5, 6, 7, 0);
		System.out.println(sum);
	}

	public static int add(int... values) {
		int sum = 0;
		for (int item : values) {
			sum += item;
		}
		return sum;
	}

}
