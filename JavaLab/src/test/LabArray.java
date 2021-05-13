package test;

import java.util.Arrays;

public class LabArray {
	public static void main(String[] args) {
		double[] x = { 1.1, 2.0, 1.2, 1.4, 0.5, 6.0 };
		Arrays.sort(x);
		System.out.println("最小值為"+x[0]);
		System.out.println("最大值為"+x[5]);
		double totalAll = (x[0]+ x[1]+x[2]+x[3]+x[4]+x[5])/x.length;
		System.out.printf("平均值為%.2f",totalAll);
	}

}
