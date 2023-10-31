package classwork;

public class Withdraw implements Runnable {
	int amount;
	Account account;
	
	Withdraw(Account account, int amount) {
		this.account = account;
		this.amount = amount;
		
	}
	@Override
	public void run() {
		this.account.withdraw(amount);
	}

}
