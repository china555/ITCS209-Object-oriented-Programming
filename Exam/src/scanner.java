import java.util.Scanner;
public class scanner 
{
	  //public static Scanner china; if here we create Scanner attributes
	  //so in main we can call like china = new Scanner(System.in);
	  
	  public static void main(String[] args) 
	  {
	    Scanner china = new Scanner(System.in);

	    System.out.println("Enter name"); // enter name in next line
	    // String input
	    String name = china.nextLine(); 
	    System.out.println("Enter age and salary");
	    //String number
	    int age = china.nextInt(); //recieve age and read Integer age 
	    double salary = china.nextDouble();

	    // Output input by user
	    System.out.println("Name: " + name); 
	    System.out.println("Age: " + age); 
	    System.out.printf("Salary: %.4f",salary);
	  }
}
