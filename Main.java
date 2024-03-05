package TestThread;

public class Main {
	public static void main(String[] args) {
		Counter counter = new Counter();
		IncrementThread it = new IncrementThread(counter, 100);
		Counter counter2 = new Counter();
		IncrementThread it2 = new IncrementThread(counter2, 99);
		it.run();
		it2.run();
	}
}
