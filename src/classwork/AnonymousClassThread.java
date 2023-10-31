package classwork;

public class AnonymousClassThread {

	// This is the same as the Runnable interface but a smartzer way of doing it

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread number : " + Thread.currentThread().getId() + " is executing");
			}
		};
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(runnable);
			thread.start();
		}
	}

}
