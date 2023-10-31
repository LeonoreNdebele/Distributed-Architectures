package classwork;

public class ThreadState {

	public static void main(String[] args) {
		
		Thread thread = new Thread(()-> {
		try {
			System.out.println("State 1 : " + Thread.currentThread().getName() + ":");
			
			Thread.sleep(3000);
			
			System.out.println("State 2 : " + Thread.currentThread().getName() + ":");

		}catch (Exception e) {
			// To do Auto generated catch block
			e.printStackTrace();
		}
		});

	}
}
