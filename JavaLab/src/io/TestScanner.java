package io;

import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("請輸入選項:");
		System.out.println("1:xxxx");
		System.out.println("2:xxxx");
		String answer = scanner.nextLine();
		int selection = Integer.parseInt(answer);
		System.out.println("使用者輸入的為"+answer);
	}

}
