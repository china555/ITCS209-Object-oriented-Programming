import java.util.Scanner;

public class ElectionTester {
	public static void main(String[] args) {
		MyDate election = new MyDate(2019, 3, 24);
		Person a = new Person("Lalisa", "Manoban",1997,3,27);
		printPersonElectionInfo(a, election);
		
		Person b = new Person("Nuda", "Inter", 2012, 1, 16);
		printPersonElectionInfo(b, election);
		
		// Create another Person object with your information
		// Print your information, age, and election eligibility.
		/*
		 * YOUR CODE GOES HERE
		 */
		Person c = new Person("Kittikorn", "Keeratikriengkrai", 1999, 8, 27);
		printPersonElectionInfo(c, election);
		
		// Write a program to take 3 persons information from the user
		// (Hint: Use scanner and for loop to get input)
		
		/*
		 * YOUR CODE GOES HERE
		 */
		  /*Scanner sc = new Scanner(System.in);
		  for(int i=0;i<3;i++) {
			System.out.println("Enter firstname: ");
			String name = sc.next();
			if(name == "q") {
				break;
			}
			System.out.println("Enter Surname: ");
	     	String sur = sc.next();
	     	int  day = sc.nextInt(),month = sc.nextInt(), year = sc.nextInt();
	     	Person d = new Person(name,sur,year,month,day);
	     	printPersonElectionInfo(d, election);
		  }
		// Challenge Bonus
		// Instead of taking 3 persons' information, write a program to continuously take input from the user
		// until the user types 'q' to quite the program.
		
		/*
		 * YOUR CODE GOES HERE
		 */
		Scanner sc = new Scanner(System.in);
		  for(int i=0;i<3;i++) {
			System.out.print("Enter firstname or type 'q' to exit: ");
			String name = sc.next();
			if(name.equals("q")) {
				System.out.println("Exit the program. Thank you.");
				break;
			}
			System.out.print("Enter Surname: ");
	     	String sur = sc.next();
	     	System.out.print("Enter year of birthday : ");
	     	int  year = sc.nextInt();
	     	System.out.print("Enter month of birthday : ");
	     	int	 month = sc.nextInt(); 
	     	System.out.print("Enter day of birthday : ");
	     	int	 day = sc.nextInt();
	     	Person d = new Person(name,sur,year,month,day);
	     	printPersonElectionInfo(d, election);
		  }
}
	public static void printPersonElectionInfo(Person p, MyDate election) {
		p.printPersonInfo();
		System.out.println("Age: " + p.getAge(election));
		if(p.isEligible(election))
			System.out.println("This person is eligible to vote.");
		else
			System.out.println("This person is NOT eligible to vote");
		
		System.out.println("-----------------------------------");
	}
}
