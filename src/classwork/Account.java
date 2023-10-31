package classwork;

import java.util.Objects;

public class Account {

	private int balance;
	private int accountNo;

	public Account(int first, int second) {
		setBalance(first);
		setAccountNo(second);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNo, balance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accountNo == other.accountNo && balance == other.balance;

		// return this.hashCode() == obj.hashCode() this check is the hashcodes are the
		// same
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	void displayBalance() {
		System.out.println("Account No : " + accountNo + "  " + balance);
	}

	synchronized void deposit(int amount) {
		this.balance = this.balance + amount;
		System.out.println(amount + " is deposited");
		displayBalance();

	}

	public synchronized void withdraw(int amount) {
		balance = balance - amount;
		System.out.println(amount + " is withdrawn");
		displayBalance();

	}

	public void credit(int amount) {
		balance = balance + amount;
		System.out.println(amount + " is credited to account : " + this.accountNo);
		displayBalance();
	}

	public void debit(int amount) {
		balance = balance - amount;
		System.out.println(amount + " is debited from account : " + this.accountNo);
		displayBalance();

	}

}
