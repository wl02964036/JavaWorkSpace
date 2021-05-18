package collection;

import java.util.HashSet;
import java.util.Set;

import equals.Employee;

public class TestHash {

	public static void main(String[] args) {


		Set set = new HashSet();
//		System.out.println("001".hashCode());
		Employee e1 = new Employee("001");
//		Employee e2 = e1;
		Employee e2 = new Employee("001");
		set.add(e1);
		boolean success = set.add(e2);
		System.out.println("加第二次Employee 001:"+success);
		
		System.out.println("size="+set.size());

	}

}
