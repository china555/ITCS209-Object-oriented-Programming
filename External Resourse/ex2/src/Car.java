
public class Car {
	public double efficiency;
	public double amount_of_fuel=0;
	Car(double efficiency){
		this.efficiency = efficiency;
	}
	public void drive(double distance) {
		this.efficiency = this.amount_of_fuel-(distance/this.efficiency);
	}
	public double getGasInTank() {
		return this.efficiency;	
	}
	public void addGas(double litter) {
		this.amount_of_fuel += litter;
	}
}
