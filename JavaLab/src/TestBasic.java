
public class TestBasic {
	
	
	public static void main(String[] args) {
		
		long salary_Mary = 1000;
		long salary_David = 1000;
		int commission_Mary = 10;
		int commission_David = 10;
		
		
		{
			long salary = 20000;  
			System.out.println("salary=" + salary );//ctrl + f11
		}
		int i,j=10,k;
		i=10;
		System.out.println("i="+ i +",j="+j);
		//int +- 21e
		System.out.println(2234567890L);//long(8)
		
		int a = 2000000000;//int : +-21e
		long b = a + a;//40e overflow
		System.out.println("b="+ b);
		
		char c = '中';//單引號,字元, 雙引號叫字串,多個字元,後面章節會介紹
		System.out.println(c);
		boolean d = false;//true, 1 bit
		System.out.println(d);
		//8基本型態,4整數,2浮點數(float,double),char, boolean
		
		System.out.println("\"HelloWorld\"");
		System.out.println("\\HelloWorld\\");
		System.out.println("Hello\r\nWorld");
			
		int x = 10;
		int y = 3;
		int z = x % y;
		System.out.println("z="+ z );
		
		System.out.println( x / y );
		
		short xx = 10;
		short yy = 3;//short:(2)
		int zz = xx + yy;//int(4),雖然兩個都是short,至少要是int,運算完至少要是int
		
		double xxx = 10.0;
		int   yyy = 5;
		double zzz = xxx + yyy;//double + int => double + double -> double
		
		
		double ccc = 10.34567;
		int aaa = (int)ccc;
		System.out.println("aaa="+aaa);
		
		int age = 40;
		boolean isAdult = (age < 18 || age > 30 ); // || , !
		System.out.println(isAdult);
		
		System.out.println( 12 | 6 );//bit &
		System.out.println( 2 << 1 );// << x 2 n
		
		++age;//age++;
		System.out.println("age="+(++age) );
		System.out.println(age);
		
		age += 10;// age = age + 10
		System.out.println(age);
		
		float qw = 4.0f;
		qw += 1.0;// qw = qw + 1.0-> double
		//qw = (float)(qw + 1.0);
		float ww = qw;
		
		
		System.out.println(  ( age > 18 ? "成年" : "未成年" )    );
		
		int sales = 2000;
		int salary = 100;
		salary = sales > 1000 ? salary + 10 : salary -10;//if else
		System.out.println("salary="+salary);
		
		System.out.println( age++ );
		
	}
}




















