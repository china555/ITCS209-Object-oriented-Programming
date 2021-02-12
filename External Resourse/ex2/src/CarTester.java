
public class CarTester {
	public static void main(String[] args) {	
	Car myCar = new Car(20);
	myCar.addGas(40);
	myCar.drive(100);
	double gasleft = myCar.getGasInTank();
	System.out.println(gasleft);
	}
}
