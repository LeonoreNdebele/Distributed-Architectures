package classwork;

public class LambdaThread {

	public static void main(String[] args) {

		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(() -> {
				System.out.println("Thread number : " + Thread.currentThread().getId() + " is executing");
			});
			thread.start();
		}
	}
}
