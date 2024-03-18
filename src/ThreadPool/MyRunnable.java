package ThreadPool;

public class MyRunnable implements Runnable{
	
	String name;
	public MyRunnable(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println(name + " running...");
		try {
			Thread.sleep(3000);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(name + " win!");
	}

}
