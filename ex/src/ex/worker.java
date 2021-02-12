package ex;

public class worker 
{
	//i luv <3
	public String firstname;
	public String lastname;
	public String id;
	private int salary;

	public worker(String firstname, String lastname, String id,int salary) 
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
		this.salary = salary;
	}

	public int getSalary() 
	{
		return salary;
	}

	public void setSalary(int salary) 
	{
		this.salary = salary;
	}
}
