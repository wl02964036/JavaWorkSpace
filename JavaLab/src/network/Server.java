package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		//如果需要close()，要用try with resource
		//try()裡無法使用alt+shift+l，所以建議程式先移出try，弄完再移回去
		System.out.println("Server啟動中，等候連線");
		try(ServerSocket ssc = new ServerSocket(8080);
			Socket socket = ssc.accept();//等候別人連線，沒有人連進來，程式會一直停在這行	
			//從對方主機讀資料	
			InputStream inputStream = socket.getInputStream();	
			InputStreamReader isr = new InputStreamReader(inputStream,"UTF8");
			BufferedReader bReader = new BufferedReader(isr);
			////寫到對方主機	
			OutputStream outputStream = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(outputStream,"UTF8");
				){
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
