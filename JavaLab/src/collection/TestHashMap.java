package collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.Map.Entry;

import sun.security.util.UntrustedCertificates;

public class TestHashMap {

	public static void main(String[] args) {

		Map<String, Integer> map = new LinkedHashMap<>();
//		Map map = new HashMap();
//		Map map = new LinkedHashMap();//加入順序
//		Map KeySet = map;
		map.put("John", 2000);
		map.put("David", 1000);
		map.put("Tom", 5000);
		map.put("Tom", 2500);// 第二次會把第一次的值蓋掉

//		map.containsKey("Tom");
//		map.containsValue(2500);

//		System.out.println("Tom's 薪水="+ KeySet.get("Tom"));
		System.out.println("Tom's 薪水=" + map.get("Tom"));

//		Set keySet = map.keySet();//alt+shift+l, Tom, David, John
		Set<String> keySet = map.keySet();// alt+shift+l, Tom, David, John
//		for( Object key : keySet) {
		for (String key : keySet) {
			System.out.println(key + "=" + map.get(key));
		}

		System.out.println("=========================================");

		// EntrySet
//		Set entrySet = map.entrySet();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		int sum = 0;// 1.
//		for(Object e : entrySet) { //java.util.Map.Entry
		for (Entry<String, Integer> entry : entrySet) {
//			Map.Entry entry = (Map.Entry)e;
//			Entry entry = (Map.Entry)e;//因為import java.util.Map.Entry;
//			Object value = entry.getValue();//2.
//			sum = sum+(Integer)value;//3.
			sum = sum + entry.getValue();
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
		System.out.println("總和" + sum);// 4.

		System.out.println("----------for each-----------");

		BiConsumer<String, Integer> consumer = (key, value) -> {
			System.out.println("key=" + key + ",value=" + value);
		};
		map.forEach(consumer);

	}

}
