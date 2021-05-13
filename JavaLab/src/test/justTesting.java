package test;
import java.util.Arrays;

public class justTesting {

	public static void main(String[] args) {
		
				int[] arr = new int[]{12,3,5,21,4,85,6,9,2,1};
				for (int i : arr) {
					System.out.print(i+" ");
				}
				Arrays.sort(arr);
				System.out.println("\nAfter Sorting...");
				for (int i : arr) {
					System.out.print(i+" ");
				}
			}
		

	}


