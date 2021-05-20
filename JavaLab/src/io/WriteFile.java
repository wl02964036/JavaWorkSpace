package io;

import java.awt.event.FocusEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) {

		try (FileOutputStream bos = new FileOutputStream("C:\\java\\io_2.txt");) {

			String content = "中文abc";
			bos.write(content.getBytes());// 文字轉byte陣列getbytes()
			System.out.println("finish");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
