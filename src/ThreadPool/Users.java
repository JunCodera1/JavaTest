package ThreadPool;

public class Users implements Runnable{
	int id;
	public Users(int id) {
		this.id = id;
	}
	public void run() {
		System.out.println("User " + id);
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Execution " +id + " success!");
	}
}
