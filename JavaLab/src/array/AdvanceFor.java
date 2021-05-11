package array;

public class AdvanceFor {

	public static void main(String[] args) {
		int[][] x = { { 1, 2, 3 }, { 4, 5 } };

		for (int[] a : x) {
			for (int b : a) {
				System.out.println(b);
			}

		}

	}
}
