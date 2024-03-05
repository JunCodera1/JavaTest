package TestThread;

public class IncrementThread extends Thread {
	
	private Counter counter;
	
	private int IncrementsPerThread;
	
	public IncrementThread(Counter counter, int IncrementsPerThread) {
		this.counter = counter;
		this.IncrementsPerThread = IncrementsPerThread;
	}
	public void run() {
		for(int i = 0; i < IncrementsPerThread; i++) {
			try {
				counter.increment();
			}catch(InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
