package category;

import category.*;
import java.lang.*;

//category.TestPackage
public class TestPackage {

	public static void main(String[] args) {
		//在package下的類別必須使用全名
		Item item = new Item();
		item.name = "Asus notebook";
		
		System.out.println("TestPackage's main : "+item.name);
		
	}

}
