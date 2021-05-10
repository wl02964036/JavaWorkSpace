import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class TestSringBuilder {

	public static void main(String[] args) {

		String hello = "hello";//pool
		String world = "world";//pool
		String helloworld = "helloworld";//pool
		
		String hwString = hello + world;
		
		System.out.println(hwString == helloworld);//helloworld
		//hw = new String("HelloWorld");//heap != pool
		
		String temp = "";
		for(int i = 0; i < 10 ; i++) {
			temp = temp + i;
			//i = 0 , temp = "" + 0 = "0"
			//i = 1 , temp = "0" + 1 = "01"......
		}
		System.out.println(temp);
		//大量文字串請用StringBuilder，請不要用加號
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < 10 ; i++) {
			builder.append(i);
		}
		System.out.println(builder.toString());
	}

}
