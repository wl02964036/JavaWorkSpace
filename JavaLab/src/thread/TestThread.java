package thread;

import javax.xml.stream.events.StartDocument;

public class TestThread {

	public static void main(String[] args) {

		/*
		 * MyThread t1 = new MyThread(); t1.setName("倒數執行緒"); t1.start();
		 * System.out.println("Main方法結束");
		 */
		
/*		
		Runnable runnable = new Runnable() {

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
		};
		Thread t2 = new Thread(runnable);
*/	
		
//		System.exit(0);
//		Runtime.getRuntime().exit(0);	
		Thread t2 = new Thread(new Runnable() {

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
		});
		
		
		t2.setName("Runable倒數");
		t2.setPriority(10);
//		t2.setDaemon(true);//設成背景執行緒，java不會等他執行完
		t2.start();
		try {
			t2.join();//從非同步變成同步
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("t2 is alive = "+t2.isAlive());
		System.out.println(Thread.currentThread());//main Thread
		System.out.println("Main方法結束");
	}

}
