import java.awt.Point;

public class testcar {
	public static void main(String[] args) {
		car honda = new car(7, "Dream", 1, 20, "pink");
		car missu = new car(1, "Nam", 2, 1, "Pink");
		honda.doors = 0;
		honda.setColor("Blue","china");
		System.out.println(honda);
		System.out.println(missu);
	}
}
