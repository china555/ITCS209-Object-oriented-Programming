
public class Car {
	private int engine;
	public String name;
	public int door;
	public static int count = 0;
	public Car(int engine2, String name, int door) {
		this.engine = engine2;
		this.name = name;
		this.door = door;
		count++;
	}
	public Car(String name, int door) {
		this.name = name;
		this.door = door;
	}
	public int poom() {
		return engine;
	}
	public void leo(int engine) {
		this.engine = engine;
	}
}
