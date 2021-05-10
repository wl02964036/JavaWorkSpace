package func;

import com.sun.org.apache.bcel.internal.generic.StackConsumer;

public class TestFunc {

	public static void main(String[] args) {
		int sum = add(1, 2);
		System.out.println(sum);

	}
//               2    =   1    +    1
	public static int add(int a, int b) {
		int c = a + b;// c=1+1
		return c;
	}

}
