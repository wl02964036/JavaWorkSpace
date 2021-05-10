
public class TestEmployee {
	

	public static void main(String[] args) {
		//basic 8, 4 int, 2 float, char , boolean
		int      a   = 1;
		Employee emp = new Employee();// 產生物件
		emp.name = "Vincent";
		emp.empno = 100;
		
		Employee emp2 = new Employee();
		emp2.name = "Mary";
		emp2.empno = 200;
		//取值跟設值都是用.
		System.out.println(emp.name);
		System.out.println(emp2.empno +",name="+emp2.name);
		System.out.println( a == 1 );//true
		System.out.println( emp == emp2 );//0800 == 0900, ctrl + alt +down, copy
		
		emp2 = emp;// emp2 = 0800
		System.out.println( emp == emp2 );//0800 == 0800, true
		
		//emp = null;
		//emp2 = null;
		System.out.println(emp.name);
		
		System.out.println("finish");
		
	}
}





