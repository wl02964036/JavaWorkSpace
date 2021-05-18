package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class TestArrayList {

	public static void main(String[] args) {
		
		List<String> list2 = Arrays.asList("Hello","World");//alt+shift+l
		List<Integer> list3 = Arrays.asList(1,2,3);
		
//		ArrayList list = new ArrayList();
//		List list = new ArrayList();//建議這樣寫
		List<String> list = new ArrayList<>();
		list.add("Hello");//0
		list.add("World");//1
		Double d = new Double(3.0);//3.0的物件,boxing
//		double e = d.doubleValue();//unboxing
		double e = d.intValue();//unboxing
//		list.add(3.0);//2 , java自動轉換成 list.add(new Double(3.0));
		Double f = Double.valueOf("3.0");
		Double g = Double.valueOf(3.0);
		System.out.println("3.0"+1);
		System.out.println(f+1);
		System.out.println(g+1);
		
		System.out.println("Size:"+list.size());
		//get(index),index從0起算
		System.out.println("第一個:"+list.get(0));
		System.out.println("第二個:"+list.get(1));
//		System.out.println("第五個:"+list.get(4));
		
		//                 3 ,(0,1,2)
		for( int i=0; i< list.size(); i++) {
			System.out.printf("第%d個:%s\r\n",(i+1),list.get(i));
		}
		
		System.out.println("===============================");
		
		//Interator		
//		Iterator iterator = list.iterator();//alt+shift+l
		Iterator<String> iterator = list.iterator();//alt+shift+l
		
//		if(iterator.hasNext()) {//有沒有下一筆
//			Object item = iterator.next();//移到下一筆，把值取出
//			System.out.println(item);
//		}
		
		while(iterator.hasNext()) {
//			Object item = iterator.next();
			String item = iterator.next();
			System.out.println(item);
		}
		System.out.println("============================");
		//for
		//Hello,World,3.0-->java.lang.object
		//改成List<String> list = new ArrayList<>();後，Hello,World,3.0都變成String
//		for(Object  item : list) {
		for(String  item : list) {
			System.out.println(item);
		}

	}

}
