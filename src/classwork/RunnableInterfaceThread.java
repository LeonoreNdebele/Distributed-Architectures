package classwork;

public class RunnableInterfaceThread implements Runnable{
	
	@Override
	public void run() {
		try {
			System.out.println("Thread number : " +  Thread.currentThread().getId() + " is executing");// here I used .get instead of thread because I have an old library
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(new RunnableInterfaceThread());
			thread.start();
		}
	}

}
