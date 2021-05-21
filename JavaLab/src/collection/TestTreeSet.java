package collection;

import java.io.File;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {

	public static void main(String[] args) {
		// 第一種作法
//		DescComparator comparator = new DescComparator();
		// 第二種作法, 此為anonymous class,跑出TestTreeSet$1.class
		/*
		 * Comparator com = new Comparator() { public int compare(Object o1, Object o2)
		 * {
		 * 
		 * Integer i1 = (Integer) o1; Integer i2 = (Integer) o2; if ( i1 > i2) { return
		 * -1; }else if ( i1 < i2) { return 1; } return 0;//相等情況,就隨便TreeSet排 } };
		 */

		// Lambda
		Comparator com1 = (Object o1, Object o2) -> {
			Integer i1 = (Integer) o1;
			Integer i2 = (Integer) o2;
			if (i1 > i2) {
				return -1;
			} else if (i1 < i2) {
				return 1;
			}
			return 0;

		};

		Comparator<File> com2 = (o1, o2) -> 1;// return 1; 省略成 1;//(Object o1,Object o2) 省略成 ( o1, o2)

		Set set = new TreeSet((o1, o2) -> {
			Integer i1 = (Integer) o1;
			Integer i2 = (Integer) o2;
			if (i1 > i2) {
				return -1;
			} else if (i1 < i2) {
				return 1;
			}
			return 0;
		});// 預設是由小到大,自然排序

		/*
		 * Set set = new TreeSet(new Comparator() { public int compare(Object o1, Object
		 * o2) {
		 * 
		 * Integer i1 = (Integer) o1; Integer i2 = (Integer) o2; if ( i1 > i2) { return
		 * -1; }else if ( i1 < i2) { return 1; } return 0;//相等情況,就隨便TreeSet排 }
		 * });//預設是由大到小
		 */

//		Set set = new TreeSet();// 預設由小到大，自然排序
//		Set set = new TreeSet(com);
		set.add(4);// autoboxing
		set.add(3);// autoboxing
		set.add(2);// autoboxing
		set.add(1);// autoboxing

		for (Object item : set) {
			System.out.println(item);

		}

	}

}
