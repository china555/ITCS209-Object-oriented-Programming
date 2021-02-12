
public class BankAccountTester {
	public static void main(String[] args) {
		BankAccount ATM = new BankAccount();
		ATM.deposit(1000);
		ATM.withdraw(500);
		ATM.withdraw(400);
		System.out.println(ATM.balance);
		
	}

}
