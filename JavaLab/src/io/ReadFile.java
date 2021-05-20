package io;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {

		//try with resource,IO,JDBC(close db connection)
		try(FileInputStream fis = new FileInputStream("c:\\java\\io_1.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);
				) {// binary,二進位
//			FileInputStream fis = new FileInputStream("c:\\java\\io_1.txt");
			
			

			System.out.println("available=" + bis.available());// 相當於file.length()

			int data = bis.read();// 讀一個byte，目前限定英文根數字//回傳直如果是-1，表示讀完了
			char c = (char) data;// 中文不能這樣用，英數可以這樣用
			System.out.println(c);// 人眼看的
			System.out.println(data);// 電腦看的
			System.out.println("available=" + bis.available());// 相當於file.length()
			
			while ((data = bis.read()) != -1) {
				System.out.println((char) data);// 跑出io_1.txt內的所有內容
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

/*這是jdk7以前的close()語法，看看就好
		} finally {

			try {
				if( fis != null) {//FileNoFoundException,fis會是空值null
					fis.close();// 最後一定要呼叫
				}
			} catch (Exception e2) {

			}
 */		
		}

	}

}
