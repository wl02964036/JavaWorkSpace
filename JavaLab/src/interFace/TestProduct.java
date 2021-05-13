package interFace;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import sun.util.resources.cldr.aa.CalendarData_aa_ER;

public class TestProduct {

	public static void main(String[] args) {

//		final int b = 1;
//		int b = 2// final給定值後，不能再給第二次

		NoteBook nb = new NoteBook("Asus", 30000, 365);
		// Notebook具備二個型態，一個是本身的Notebook，另一個繼承來的Product
//		Product nb = new NoteBook("Asus", 30000, 365);
//		System.out.printf("%s,%d,%d%n",nb.getName(),nb.getPrice(),nb.getWarranty());

		System.out.println(nb.desc());
//		nb.fetWarranty();
//		nb.getName();
//		nb.getPrice();
		
		Product item = nb;		//NoteBook-> Product,子類別轉成父類別
		System.out.println( item instanceof Food );
		System.out.println( item instanceof NoteBook );//true
		if(item instanceof NoteBook) {
			NoteBook nb1 = (NoteBook)item;
			System.out.println("保固:"+nb1.getWarranty());
			
		}
		
		NoteBook nb1 = (NoteBook)item;//Product -> NoteBook(?),父類別轉成子類別
//		Food f1 = (Food)item;	//Product -> NoteBook(?),父類別轉成子類別
		
		//nb.getwarranty();
		//System.out.println(-0.0);

//		Product a = new Product("冷氣",50000);
//		a.calc();
//		System.out.println(a.name);
//		System.out.println(a.desc());

		// 先取得日曆Calendar再取得日期Date,m,月份0起算,其他是1起算
//		GregorianCalendar calendar = new GregorianCalender(2021,5,13);		

//		GregorianCalendar calendar = new GregorianCalendar(2021, Calendar.MAY, 13);
//		Date date = calendar.getTime();
		Date date = Product.getDate(2021, 5, 13);
		Food food = new Food("肉鬆", 200, date);
		System.out.println(food.desc());
		
		GregorianCalendar calendar1 = new GregorianCalendar(2021, Calendar.MAY, 13);
		Date date1 = calendar.getTime();
		SimCard sim = new SimCard("日本漫遊", 600, date);

//		buy(nb);
//		buy(food);
		
//		Product[] items = new Product[] {nb,food};
		Product[] items = {nb,food};
		buy(items);

	}


	public static void buy(Product[] ps) {
		int sum = 0;
		for(Product eachItem : ps) {
			System.out.println("買入:" + eachItem.desc());	
			sum = sum + eachItem.getPrice();
		}
		System.out.println("總金額:"+sum);
		
//	public static void buy(Product n) {
//		System.out.println("買入:" + n.desc());
//	public static void buy(NoteBook n) {
//		System.out.println("買入:" + n.desc());
	}

//	public static void buy(Food f) {
//		System.out.println("買入:" + f.desc());
//	}
}
