package exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestException2 {

	public static void main(String[] args) {
		//呼叫方法
		try {
			checkFile("c:\\java\\aaa.txt");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		System.out.println("done");
	}
	
	public static void checkFile(String filePath) throws FileNotFoundException{
		
		File file = new File(filePath);
		if(!file.exists()) {
			//產生exception物件
//			FileNotFoundException fne = new FileNotFoundException(filePath);
//			throw fne;
			throw new FileNotFoundException(filePath+", aaa");
//			System.out.println("aaa");//不會被執行到的城程式
		}
	}

}
