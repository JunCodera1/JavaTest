package TestThread;

public class Counter {
	private int count = 0;
	
	public synchronized void increment()throws InterruptedException{
		count++;
		System.out.println(" " + count + " ");
		Thread.sleep(1000);
	}
	
	public int getCount() {
		return count;
	}
}
