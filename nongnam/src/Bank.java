import java.util.ArrayList;

public class Bank {
	//1.variable
	private ArrayList<BankAccount> accounts;
	public double totalbalance=0;
	
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
		for(BankAccount i : accounts) 
		{
			this.totalbalance = this.totalbalance + i.getBalance();
		}
        return this.totalbalance;    
        
	}
	//counts the number of bank account whose balance is at least given value.
	public int countBalanceAtLeast(double atLeast){
		//put your code here
		int count = 0 ;
		for(BankAccount i : accounts)
		{
			if (i.getBalance() < atLeast) 
			{
				count++;
			}
		}    
        
	}
	//finds a bank account with a given number
	public BankAccount find(int accountNumber){
		//put your code here
        
        
        
	}
	//gets the bank account which has minimum balance.
    public BankAccount getMin(){
        //put your code here
        
        
    }	
}
