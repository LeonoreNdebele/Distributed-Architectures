package lecture4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorPool implements Runnable {

	private String message;

	public ExecutorPool(String msg) {
		this.message = msg;
	}

	@Override
	public void run() {
		// Print a message when a thread starts
		System.out.println(Thread.currentThread().getName() + " Start receiving message: " + message);

		try {
			// Simulate some work by making the thread sleep for 3 seconds
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Print a message when the thread is done
		System.out.println(Thread.currentThread().getName() + " End.");
	}

	public static void main(String[] args) {
		// Create a fixed-size thread pool with 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 10; i++) {
			// Create a new worker (task) with a message
			Runnable worker = new ExecutorPool("" + i);

			// Submit the worker to the thread pool for execution
			executor.execute(worker);
		}

		// Shut down the executor after all tasks are submitted
		executor.shutdown();

		// Wait for all threads to finish
		while (!executor.isTerminated()) {
		}

		// Print a message when all threads have finished
		System.out.println("Finished all threads");
	}

}
/*
 * In this code:
 * 
 * The ExecutorPool class implements the Runnable interface and defines a task
 * that prints messages and simulates work with a 3-second sleep.
 * 
 * In the main method: An ExecutorService is created with a fixed pool size of 3
 * threads. A loop submits 10 tasks to the executor pool. Each task is an
 * instance of ExecutorPool with a unique message. After submitting all tasks,
 * the executor is shut down. The code waits for all threads to finish using a
 * loop. A message is printed when all threads have completed their work.
 */
