package classwork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorSingleThread {

	
	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.execute(()->{System.out.println("Thread number : " + Thread.currentThread().getId() + " is executing");
		});
		
		}
		
	}
		



