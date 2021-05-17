package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.zip.ZipException;

public class TestCheckException {

	public static void main(String[] args) throws IOException {
		//可以用兩個反斜線或單斜線作為目錄區隔符號
		//ctri+1:fix , implement
		FileReader fr = new FileReader("c:\\java\\aaa.java");
		
		System.out.println("done");
		//java: JVM
		//FileReader fr = new FileReader("c:/java/aaa.txt");
	}

}
