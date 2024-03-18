package Thread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		MyThread thread1 = new MyThread();
		
		MyRunnable runnable1 = new MyRunnable();
		MyRunnable runnable2 = new MyRunnable();
		
		Thread thread2 = new Thread(runnable1);
		Thread thread3 = new Thread(runnable2);
		
		
		
		thread1.start();
//		thread1.join(5000);
		thread2.start();
	}

}
