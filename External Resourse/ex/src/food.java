
public class food {
	public String name;
	private String taste;
	public int amount_of_dish;
	
	public food(String name, String taste, int amount_of_dish) 
	{
		this.name = name;
		this.taste = taste;
		this.amount_of_dish = amount_of_dish;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaste() {
		return taste;
	}
	public void setTaste(String taste) {
		this.taste = taste;
	}
	public int getAmount_of_dish() {
		return amount_of_dish;
	}
	public void setAmount_of_dish(int amount_of_dish) {
		this.amount_of_dish = amount_of_dish;
	}
	
}
