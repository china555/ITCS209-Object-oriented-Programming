
public class Person 
{
	private String name;
	private int age;
	private double balance;
	
	public Person(String name, int age) 
	{
		this.name = name;
		this.age = age;
		this.balance = 0;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	 
	public double getInterest(double rate)
	{
		return rate*this.balance;
	}
}
