import java.util.ArrayList;
import java.util.Scanner;

public class Array {
	public static int[] array;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int tire = sc.nextInt();
		String name = sc.next();
		int doors = sc.nextInt();
		int engine = sc.nextInt();
		String color = sc.next();
		ArrayList<car> data = new ArrayList<car>();
		car honda = new car(7, "Dream", 1, 20, "pink");
		car missu = new car(1, "Nam", 2, 1, "Pink");
		car toyota = new car(2, "Jun", 6, 1000, "green");
		car ferrari = new car(6, "Komadikub", 2, 10000, "black"); 
		data.add(missu);
		data.add(toyota);
		data.add(honda);
		car lambo = new car(tire, name, doors, engine, color);
		data.add(ferrari);
		data.add(lambo);
		data.get(1).name = "leo";
		
		for(car i : data) {
			System.out.println(i.doors);
		}
	}

}
