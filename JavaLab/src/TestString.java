
public class TestString {

	public static void main(String[] args) {

		String name = "Vincent";// pool會產生vincent字，回傳記憶體位置給name變數
		String name1 = "Vincent";// 第二次再要，pool直接回傳vincent記憶體位置給name1，不會再產生新字

		String name2 = new String("vincent");// new會產生在heap區，不會在pool內

		System.out.println(name == name1);

		System.out.println(name2 == name1);// heap(new) != pool("")

		System.out.println("equals=" + name.equals(name1));// 文字逐字比較，要用equal()
		System.out.println("equals=" + name1.equals(name2));// 文字逐字比較，要用equal()

		System.out.println("你好.abc".length());
		
		System.out.println("你好.abc".indexOf("你好"));//第一個字的位置是0

		System.out.println("你好.abc".contains(".a"));//
		
		System.out.println("你好.abc".substring(1));//true or false

		System.out.println("你好.abc".substring(1,4));//

		System.out.println(String.format("Hello World %10s", "David"));//
		
		System.out.println(String.format("%5.4f",10/3.0));
		
		System.out.println(String.format("aaa bbb %12d%%",10));

		System.out.printf("aaa bbb %12d",10);//f:format
		
	}

}
