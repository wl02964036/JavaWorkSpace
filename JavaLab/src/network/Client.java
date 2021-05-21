package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {

		try (Socket socket = new Socket("127.0.0.1", 8080);
				// 從對方主機讀資料
				InputStream inputStream = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(inputStream, "UTF8");
				BufferedReader br = new BufferedReader(isr);
				// 寫到對方主機
				OutputStream outputStream = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF8");
				Scanner scanner = new Scanner(System.in);) {

			Thread t1 = new Thread(new Runnable() {

				@Override
				public void run() {
					try {

						while (true) {

							String response = br.readLine();
							if (response == null) { // 表示連線已中斷
								break;
							}
							System.out.println("接收到來自Server的訊息:" + response);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
			t1.start();

			System.out.println("請輸入要傳送的文字，或者b中斷");
			String line = scanner.nextLine();
			while (line != null) {
				// 加上換行符號，因為Server是用readLine，沒有換行符號不會讀取資料
				osw.write(line + System.lineSeparator());
				osw.flush();
				System.out.println("請輸入要傳送的文字，或者b中斷");
				line = scanner.nextLine();
				if (line.equals("b")) {
					break;
				}
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
