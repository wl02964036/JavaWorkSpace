
public class TestIf {

	public static void main(String[] args) {

		int age = 40;
		// 先打一個括號,按enter,自動幫你補另一個括號
		if (age >= 18) {

			if (age >= 30) {
				System.out.println("壯年");
			}else {				
				System.out.println("成年");// alt+up down				
			}
			
		} else {
			System.out.println("未成年");
		}
//ctrl+shift+f
		
		
		int classroom = 204;
		switch ( classroom  ) {
		    case 204:
		        System.out.println("⼈數⼤於等於30⼈");
		        break;
		    case 305:
		        System.out.println("⼈數⼩於30⼤於等於20⼈");
		        break;
		    default:
		        System.out.println("default 其它");
		}
		
	}

}








