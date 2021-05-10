import com.sun.java.swing.plaf.windows.WindowsButtonUI;

public class testasd {

	public static void main(String[] args) {

//		int sum = 0;
//		for (int i = 1 ; i <= 100 ; i++) {
//			if ( i % 2 == 0) {
//				continue;
//			}
//			if (i >= 50) {
//				break;
//			}
//			System.out.println(i);
//			sum = sum + i;
//		}
//		System.out.println("總和="+sum);

		
		int i = 1;
		int sumOfWhile = 0;
		while (i <= 100) {
			sumOfWhile = sumOfWhile + i;
			i++;
//			System.out.println(i);
		}
		System.out.println("While總和="+sumOfWhile);
		
		
		System.out.println("-----------do while-----------");
		int j =1;
		int sumOfDoWhile = 0;
		do {
			sumOfDoWhile = sumOfDoWhile + j;
			j++;
		}while (j <= 100);
		System.out.println("Do While 總和="+sumOfDoWhile);
		
	}
	

}
