package lecture4;

public class VolatileExample {
	
	private volatile static int number; // Declare a volatile static integer variable.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create a thread for reading the 'number' variable.
		Thread reader = new Thread(() -> {
			int temp = 0;
			while (true) {
				if (temp != number) {
					temp = number;
					System.out.println("Reader: value of counter = " + number);
				}
			}
		});

		// Create a thread for writing to the 'number' variable.
		Thread writer = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				number++; // Increment the 'number' variable.
				System.out.println("Writer: changed value to = " + number);
				try {
					Thread.sleep(3000); // Sleep for 3 seconds.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.exit(0); // Exit the program after writing 5 times.

		});		

		// Start the reader and writer threads.
		reader.start();
		writer.start();
	}

}



