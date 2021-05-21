package thread;

public class FoodMonster extends Thread {

	private volatile int food = 5;
	private Object lockObject = new Object();//1.

	public void eat() {
		// 檢查是否有食物，沒有食物則利用while迴圈一直等候
		while (food == 0) { // food==0 就像 while true
			synchronized (lockObject) { //2.
				try {
					lockObject.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 利用這種方式會一直執行，浪費cpu cycle//所以要加synchronized
			// System.out.println(Thread.currentThread().getName()+":沒有食物，等待中");
		}
		for (int i = 0; i < 5; i++) {
			food--;
			System.out.println(Thread.currentThread().getName() + "吃掉一個剩下" + food + "個");
		}
		System.out.println(Thread.currentThread().getName() + ":吃完了");

	}

	public void feed() {
		food = 5;
		synchronized (lockObject) { //3.
			lockObject.notify();
		}
		System.out.println("餵食時間到，" + this.getName() + " 有" + food + "個食物囉！");
	}

	@Override
	public void run() {
		while (true) {
			eat();
		}
	}

}
