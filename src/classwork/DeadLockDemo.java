package classwork;

import java.util.Random;

public class DeadLockDemo {

	static public void transferMoney(Account fromAccount, Account toAccount, int amount)
			throws InsufficientFundsException {
		System.out.println("Thread " + Thread.currentThread().getId() + " is transferring money from account "
				+ fromAccount.getAccountNo() + " to account  : " + toAccount.getAccountNo());
		synchronized (fromAccount) {
			synchronized (toAccount) {
				System.out.println("Balance of " + fromAccount.getAccountNo() + " is : " + fromAccount.getBalance());

				if (fromAccount.getAccountNo() != toAccount.getAccountNo()) {
					fromAccount.debit(amount);
					toAccount.credit(amount);
				}
			}
		}
	}

	private static final int NUM_THREADS = 2;
	private static final int NUM_ACCOUNTS = 2;
	private static final int NUM_ITERATIONS = 100000;

	public static void main(String[] args) {

		Random rnd = new Random();
		final Account[] accounts = new Account[NUM_ACCOUNTS];

		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(rnd.nextInt(1000), i);

		}
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for (int j = 0; j < NUM_ITERATIONS; j++) {
					int fromAcct = rnd.nextInt(NUM_ACCOUNTS);
					int toAcct = rnd.nextInt(NUM_ACCOUNTS);
					int amount = rnd.nextInt(1000);
					try {
						transferMoney(accounts[fromAcct], accounts[toAcct], amount);
					} catch (InsufficientFundsException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		};

		for (int i = 0; i < NUM_THREADS; i++) {
			Thread t = new Thread(runnable);
			t.start();
		}
	}

}
