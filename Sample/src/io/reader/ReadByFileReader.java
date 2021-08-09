package io.reader;

import java.io.*;
import java.nio.charset.Charset;

public class ReadByFileReader {
    public static void main(String[] args) throws IOException {

        System.out.println("目前JVM編碼＝"+Charset.defaultCharset());
        //Linux: ios-8859-1; Mac: utf8, Windows: Ms950
        File file = new File("C:\\java\\char_MS950.txt");

        try(
        	FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"MS950");
            BufferedReader br = new BufferedReader(isr);
            ){
            	
            
/*
                int c;
                  while ((c = isr.read()) != -1) {
                    System.out.println((char) c);
                  }
                  
*/   
        	
                  String line;
                  while ((line = br.readLine()) !=null ) {
                	  System.out.println(line);
                  }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
