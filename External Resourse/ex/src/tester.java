import java.util.Scanner;

public class tester {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert name");
		String name = sc.nextLine();
		System.out.print("Insert ID");
		int id = sc.next;
		System.out.print("Insert surname");
		String sur = sc.nextLine();
		Car nissan = new Car(1000, "John", 8);
		Car Toyota = new Car("OHM", 48);
		Car Ferrari = new Car(6000, "Pon",20);
		Student john=new Student(id,name,sur);
		nissan.leo(2000);
		System.out.print(john.getId()+" "+john.getName()+" "+john.surname);
	}
}
