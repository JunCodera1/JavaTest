package ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
	public static void main(String[] args) {
		
		int max = 20;
        int min = 1;
        int range = max - min + 1;
 
		int corePoolSize = 5;
		int maxPoolSize = 10;
		int keepAlivetime = 100;
		TimeUnit unit = TimeUnit.SECONDS;
		
		ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(200);
		
		CallerRunsPolicy handler = new ThreadPoolExecutor.CallerRunsPolicy();
		
		 ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,
				 maxPoolSize, keepAlivetime, unit, workQueue, handler);
	         for (int i = 0; i < 20; i++) {
	        	 int rand = (int)(Math.random() * range) + min;
	            threadPoolExecutor.execute(new Users(rand));
	       }
	}
}
