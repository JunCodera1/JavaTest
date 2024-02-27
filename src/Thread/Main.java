package Thread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread thread1 = new MyThread();
		
		MyRunnable runnable1 = new MyRunnable();
		
		Thread thread2 = new Thread(runnable1);
		
		thread1.setDaemon(false);
		thread2.setDaemon(true);
		
		thread1.start();
//		thread1.join(5000);
		thread2.start();
	}

}
