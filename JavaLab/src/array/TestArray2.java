package array;

import com.sun.xml.internal.ws.resources.AddressingMessages;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class TestArray2 {

	public static void main(String[] args) {
		/*
		int[] ages = {1,2,3};
		for(int a : ages ) {
			System.out.println(a);
		}
		
		System.out.println(ages[1]);
		System.out.println("length = "+ages.length);
		System.out.println(ages[2]);
		System.out.println("finish");
		ages = null;
		*/
		
		int[][] x = {{1,2,3},{4,5}};
//		System.out.println(x[1][1]);
		for( int[] a : x ) {
			for(int b : a) {
				System.out.println(b);
			}
		}
	}

}
