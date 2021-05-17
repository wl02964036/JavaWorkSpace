package collection;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		
//		ArrayList list = new ArrayList();
		List list = new ArrayList();//建議這樣寫
		list.add("Hello");//0
		list.add("World");//1
		list.add(3.0);//2
		
		System.out.println("Size:"+list.size());
		//get(index),index從0起算
		System.out.println("第一個:"+list.get(0));
		System.out.println("第二個:"+list.get(1));
//		System.out.println("第五個:"+list.get(4));
		
		//                 3 ,(0,1,2)
		for( int i=0; i< list.size(); i++) {
			System.out.printf("第%d個:%s\r\n",(i+1),list.get(i));
		}

	}

}
