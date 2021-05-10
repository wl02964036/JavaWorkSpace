
public class TestString {

	public static void main(String[] args) {
		//pool, new, immutable
		String name = "vincent";//pool會產生vincent字,回傳記憶體位置給name變數
		String name1 = "vincent";//第二次再要,pool直接回傳vincent記憶體位置給name1,不會再產生新的字
		
		//name = "vincent1";//immutable
		String name2 = new String("vincent");//new 會產生在heap區,不會在pool內
		
		System.out.println(name == name1);//true
		
		System.out.println(name2 == name1);//heap(new) != pool("") 
		
		System.out.println("equals="+ name2.equals(name1));//文字逐字比較,要用equals()
		
		System.out.println("中文.abc".length());
		
		System.out.println("中文abc".indexOf("文1"));//第一個字的位置是0,找不到回傳-1
		
		System.out.println("中文abc".contains("文1"));//true or false

		System.out.println("中文abc".substring(2,4));//ab
		
		System.out.println(  String.format("Hello World %10s", "David")     );
		
		System.out.println(  String.format("%.4f", 10/3.0 )   );
		System.out.println(  String.format("%12.1f", 10/3.0 )   );
		
		System.out.println(  String.format("aaa bbb %12d%%", 10)   );
		System.out.printf("aaa bbb %12d%%", 10);//f:format
			
	}
}
















