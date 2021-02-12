//Name:Nattawipa Saetae
//ID:6188089
//Section:1
public class BottleOfMilk extends Item{

	private double originalVolume = 0;		//ml
	private double currentVolume = 0;
	
	public BottleOfMilk(double _purchasePrice, double _age, double weight, double _volume) {
		super(_purchasePrice, _age, weight);
		this.originalVolume = _volume;
		this.currentVolume =this.originalVolume;
	}

	@Override
	public double getCurrentValue() {      
		//Your Code Goes Here
		return getPurchasePrice()*(this.currentVolume/this.originalVolume);
	}                                       
	
	@Override
	public String toString()
	{
		return "[Milk"+": Value = "+String.format( "%.2f", this.getCurrentValue())+" Baht, Milk left = "+getVolume()+" ml]";
	}
	
	public void drink(double vol)
	{
		System.out.println("Drinking "+vol+" ml of milk");
		currentVolume -= vol;
		if(currentVolume < 0) currentVolume = 0;
	}
	
	@Override
	public double getWeight()
	{
		return super.getWeight()*(currentVolume/originalVolume);
	}
	
	public double getVolume()
	{
		return currentVolume;
	}
	
	public BottleOfMilk clone()
	{
		//Your Code Goes Here
		BottleOfMilk deep = new BottleOfMilk(getPurchasePrice(), getAge(), getWeight(), getVolume());
		return deep;
	}
}
