import java.text.DecimalFormat;
import java.util.Scanner;

public class wednesday {
	
	public String firstname;
	public String lastname;
	private String id;
	public static double a=5;
	public static double b=10;
	public static double sum=0;
	private static Scanner china;
	
	public wednesday(String firstname, String lastname) 
	{
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public wednesday(String firstname, String lastname, String id) 
	{
		//super(); this line doesn't matter
		this.firstname = firstname;
		this.lastname = lastname;
		this.id = id;
	}
	
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	
	public static void getvalue()
	{
		china = new Scanner(System.in);
		System.out.print("Please enter A : ");
		a = china.next;
		System.out.print("Please enter B : ");
		b = china.nextDouble();
	}
	
	public static double getsum() 
	{
		return sum = a + b;
	}
	
	 // ctrl+/
//	public static void printValue() 
//	{
//		String pattern = "###,###.####";
//		DecimalFormat df = new DecimalFormat(pattern);
//		sum = a+b;
//		System.out.println("The sum is: " + df.format(sum));
//	}
}
