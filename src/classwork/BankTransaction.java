package classwork;

public class BankTransaction {

	public static void main(String[] args) {
		Account myAccount = new Account(0, 0);
		myAccount.setBalance(1000);
		myAccount.setAccountNo(1);
		Thread thread1 = new Thread(new Deposit(myAccount, 500));
		Thread thread2 = new Thread(new Withdraw(myAccount, 900));
		thread1.start();
		thread2.start();

	}
}
