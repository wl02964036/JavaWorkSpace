package thread;

public class MyThread extends Thread {

	@Override
	public void run() {

		for (int i = 5; i > 0; i--) {
			// Thread.currentThread()可以取得目前執行的執行物件
			System.out.println("倒數:" + i + "," + Thread.currentThread());
			try {
				Thread.sleep(1000);// 暫停一秒,1000 = 1秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("執行結束");

	}
}
