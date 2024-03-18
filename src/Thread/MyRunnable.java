package Thread;


public class MyRunnable implements Runnable{

	public void run(int n) {
		for(int i = 1; i <= n; i++) {
			System.out.println("Thread #2: " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Thread #2 : finished!");
	}

	@Override
	public void run() {
		for(int i = 0)
		
	}

}
