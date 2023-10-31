package classwork;

public class InheritanceThread extends Thread {

	public void run() {
		try {
			System.out.println("Thread number : " + Thread.currentThread().getId() + " is running");

		} catch (Exception e) {
			// To do Auto generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			Thread thread = new InheritanceThread();
			thread.start();
		}
	}

}
