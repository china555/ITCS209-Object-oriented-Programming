
public class Car {
	public int engine;
	public int door;
	public int tire;
	Car(int engine, int door, int tire ){
		this.engine = engine;
		this.door = door;
		this.tire = tire;
	}
	public static void main(String[] args) {
		Car Nissan = new Car(5000, 4, 10);
		Car Ferrari = new Car(9000,1,4);
		Ferrari.engine = 1000;
		Car MUICT = new Car(80000, 22, 10);
		System.out.println(MUICT.door+" "+MUICT.engine+" "+MUICT.tire);
		System.out.println(Ferrari.engine);
	}

}
