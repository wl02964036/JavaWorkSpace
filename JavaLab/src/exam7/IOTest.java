package exam7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class IOTest {
    public static void main(String[] args) throws MalformedURLException {
    		/* 
    		 http://iosnetworkdemo.appspot.com/json.jsp?msg=helloWorld，
    		會回應{"msg":"helloWorld","狀 態":"成功"}，編碼為UTF8 
    	    請利用Java程式呼叫此網址，此將此網址回傳的結果示在Console中(IOTest.java)
    	    程式中除了MalformedURLException其它 Exception處理必須使用try catch不能直接由方法抛出。
    	    所有IO都必須close
           */
    	
    	URL url = new URL("http://iosnetworkdemo.appspot.com/json.jsp?msg=helloWorld");
    	try(InputStream openStream = url.openStream();
    		InputStreamReader isr = new InputStreamReader(openStream,"UTF8");
    		BufferedReader br = new BufferedReader(isr);
    		
    	){
    		char[] buffer = new char[1024];

    		while((br.read(buffer))!= -1) {
    			br.read(buffer);
    		}
    		System.out.println(buffer);
    		
    	}catch (MalformedURLException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
		}
    }
}
