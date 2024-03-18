package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutor {

	public static <T> void printCoordinate(T latitude, T longitude) {
		
	}

	public static void main(String[] args) {
	    System.out.print("Tọa độ 1: ");
	    printCoordinate(10.78838, 106.64811);

	    System.out.print("Tọa độ 2: ");
	    printCoordinate("10.79226", "106.69437");
	}

	// Kết quả
	// Tọa độ 1: (10.78838, 106.64811)
	// Tọa độ 2: (10.79226, 106.69437)
}
