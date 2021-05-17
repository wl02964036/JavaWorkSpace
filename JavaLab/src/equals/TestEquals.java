package equals;

import com.sun.xml.internal.messaging.saaj.soap.ver1_1.Envelope1_1Impl;

import encap.Car;

public class TestEquals {

	public static void main(String[] args) {
		
		String id001 = new String("001");//在Heap區
		Employee e1 = new Employee("001");// 0800//在Pool區
		Employee e2 = new Employee("001");// 0900

		System.out.println(e1 == e2);// false
		System.out.println(e1.equals(e2));// 按F3//false,因為是用記憶體位置做比較

		Car c = new Car("Prius", 'R');
		System.out.println(e1.equals(c));//car不具備\equals屬性
		
		e1 = null;
		System.gc();//強制系統執行GC
		
		System.out.println(e2);
		System.out.println(e2.toString());//ba31預設是記憶體位置的hashcode，但改寫後就不是了

	}

}
