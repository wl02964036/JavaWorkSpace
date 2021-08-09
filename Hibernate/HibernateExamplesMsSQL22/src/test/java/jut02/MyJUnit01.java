package jut02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyJUnit01 {

	@Before
	public void aaaa() throws Exception {
		System.out.println("@Before執行中...");
	}

	@After
	public void bbb() throws Exception {
		System.out.println("@After執行中...");
	}

	@Test
	public void test() {
		System.out.println("@Test執行中...");
	}


	@Test
	public void test2() {
		System.out.println("第二個@Test執行中...");
	}

}
