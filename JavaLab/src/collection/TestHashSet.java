package collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestHashSet {

	public static void main(String[] args) {
		//util-->utility
		Set<String> set = new LinkedHashSet<>();
//		Set set = new LinkedHashSet();//Linked:紀錄加入的順序
//		Set set = new HashSet();
		set.add("Hello");
		boolean success = set.add("Hello");//alt+shift+l
		System.out.println("家第二次有沒有成功:"+success);
		System.out.println("size:"+set.size());
//		String contains = "World";
//		set.add(contains);
		set.add("World");
//		set.add(3.0);
		System.out.println("size="+set.size());
		
		boolean contains = set.contains("World");//alt+shift+l
		System.out.println("有沒有World:"+contains);
		
//		for(Object item:set) {
		for(String item:set) {
			System.out.println(item);
		}

	}

}
