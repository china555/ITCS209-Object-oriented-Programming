
public class BankAccount {
	public double balance;
	BankAccount(double balance) {
		this.balance = balance;
	}
	public BankAccount() {
		this.balance = 0;
	}
	public void deposit(double deposit) {
		balance = balance+ deposit;
	}
	public void withdraw(double withdraw) {
		balance = balance - withdraw;
	}
	public double getBalance() {
		return balance;
	}
}