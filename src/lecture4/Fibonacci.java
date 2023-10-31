package lecture4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Fibonacci implements Callable<Integer> {
	Integer n; // Represents the limit for Fibonacci numbers to calculate

	Fibonacci() {
	}

	Fibonacci(Integer n) {
		this.n = n; // Constructor to set the limit for Fibonacci numbers
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		if (n == null) {
			return sum; // If the limit is not specified, return 0
		}
		int n1 = 0, n2 = 1;
		int n3 = 1;
		for (int i = 0; i < n; i++) {
			if (n1 % 2 == 0) {
				sum += n1; // Add even Fibonacci numbers to the sum
			}
			n3 = n2 + n1;
			n1 = n2;
			n2 = n3;
		}
		System.out.println("Thread name: " + Thread.currentThread().getName()); // Print thread name
		return sum; // Return the sum of even Fibonacci numbers
	}

	public static void main(String[] args) {
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		ExecutorService executor = Executors.newFixedThreadPool(3); // Create a thread pool with 3 threads
		Fibonacci task2 = new Fibonacci(10); // Create a Fibonacci task with a limit of 10
		for (int i = 0; i < 10; i++) {
			Future<Integer> futureResult = executor.submit(task2); // Submit the task to the thread pool
			list.add(futureResult); // Store the Future result in a list
		}
		for (Future<Integer> futureResult : list) {
			try {
				System.out.println(new Date().toInstant().getNano() + "::" + futureResult.get()); // Get and print the
																									// results
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace(); // Handle exceptions
			}
			executor.shutdown(); // Shut down the thread pool
		}
	}
}
/*
 * 
 * In this code:
 * 
 * Fibonacci is a class that implements the Callable interface, and it
 * calculates the sum of even Fibonacci numbers up to a specified limit.
 * 
 * In the call method, it calculates the sum of even Fibonacci numbers up to the
 * specified limit n.
 * 
 * In the main method, a thread pool with three threads is created using
 * ExecutorService.
 * 
 * The Fibonacci task with a limit of 10 is submitted to the thread pool 10
 * times. The results are stored in a list of Future objects.
 * 
 * The results are retrieved and printed, and any exceptions are handled.
 * 
 * Finally, the thread pool is shut down.
 */