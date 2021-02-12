package ex;

class people1{
	public String name;
	public String lastname;
	public people1 (String name,String lastname) {
		this.name =name;
		this.lastname = lastname;
	}
}
class users extends people1{
	public double balance;
	public int password;
	public users(String name, String lastname,double balance,int password) {
		super(name, lastname);
		this.balance = balance;
		// TODO Auto-generated constructor stub
	}
	public void deposit(double balance) {
		this.balance = this.balance + balance;
	}
	
}
class inspectors extends people1{
	public String investigate;
	public inspectors(String name, String lastname,String investigate) {
		super(name, lastname);
		// TODO Auto-generated constructor stub
	}
	
}

public class bank {
	public static void main(String[] agrs) {
		users deposit = new users("Tar", "Tatar", 500,2314);
		System.out.println("Befor deposit"+deposit.balance);
		deposit.deposit(500);
		System.out.println("After deposit"+deposit.balance);
	}

}  
