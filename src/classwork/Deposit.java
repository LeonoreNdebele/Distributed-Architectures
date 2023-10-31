package classwork;

public class Deposit implements Runnable{
	int amount;
	Account account;
	
	Deposit(Account account, int amount) {
		this.account = account;
		this.amount = amount;
		
	}
	@Override
	public void run() {
		this.account.deposit(amount);
	}

}
