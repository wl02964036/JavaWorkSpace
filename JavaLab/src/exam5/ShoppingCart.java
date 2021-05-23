package exam5;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	public static void main(String[] args) {

		// 實作1.加入二台Notebook("Asus",30000),Notebook("Acer",20000),Food("Cookie",200)到shoppingList中
		List<Product> shoppingList = new ArrayList<Product>();
		Notebook notebook1 = new Notebook("Asus", 30000);
		Notebook notebook2 = new Notebook("Acer", 20000);
		Food food1 = new Food("Cookie", 200);
		shoppingList.add(notebook1);
		shoppingList.add(notebook2);
		shoppingList.add(food1);

		// 實作2.利用for迴圈，計算shoppingList中的總金額,並印在Console中
		int total = 0;
		for (Product product : shoppingList) {
			total = total + product.getPrice();
		}
		System.out.println(total);

		// 實作3.利用for迴圈，計算shoppingList中是Notebook型態的總金額,並印在Console中
		int notebookTotal = 0;
		for (int i = 0; i < shoppingList.size(); i++) {
			if (shoppingList.get(i) instanceof Notebook) {
				notebookTotal = notebookTotal + shoppingList.get(i).getPrice();

			}
		}
		System.out.println(notebookTotal);

	}
}
