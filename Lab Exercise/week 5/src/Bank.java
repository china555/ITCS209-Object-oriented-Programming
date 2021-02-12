import java.util.ArrayList;

public class Bank {
	//1.variable
	private ArrayList<BankAccount> accounts;
	//2.constructor
	public Bank(){
		accounts = new ArrayList<BankAccount>();
	}
	//3.methods
	//add an account to this bank
	public void addAccount(BankAccount a){
		accounts.add(a);
	}
	//gets the sum of the balances of all accounts in this bank
	public double getTotalBalance(){
		//put your code here
		double total = 0; 
		for (BankAccount a : accounts){
			 total = total + a.getBalance();
		 	}
//		for(int i=0;i<accounts.size();i++) {
//			total = total + accounts.get(i).getBalance();
//		}
		 return total;
		 
	}
	//counts the number of bank account whose balance is at least given value.
	public int countBalanceAtLeast(double atLeast){
		//put your code here
		int matches = 0;
		for (BankAccount a : accounts){
			if (a.getBalance() >= atLeast) 
				matches++; // Found a match
			}
			return matches;
	}
	//finds a bank account with a given number
	public BankAccount find(int accountNumber){
		//put your code here
		for (BankAccount a : accounts){
			 if (a.getAccountNumber() == accountNumber) // Found a match
			return a;
			 }
			 return null;
	}
	//gets the bank account which has minimum balance.
    public BankAccount getMin(){
        //put your code here
    	if (accounts.size() == 0) return null;
    	 BankAccount smallYet = accounts.get(0);
    	 for (int i = 1; i < accounts.size(); i++)
    	 {
    	 BankAccount a = accounts.get(i);
    	 if (a.getBalance() < smallYet.getBalance())
    	 smallYet = a;
    	 }
    	 return smallYet;
    	 }

}
