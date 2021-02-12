
public class car {
	public int tire;
	public String name;
	public int doors;        //attribute
	public int engine;
	private String color;
	car(int tire,String name,String color){
		this.tire = tire;
		this.name = name;
		this.color = color;
	}
	public car(int tire, String name, int doors, int engine, String color) {
		this.tire = tire;
		this.name = name;
		this.doors = doors;
		this.engine = engine;
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color,String name) {
		this.color = color;
		System.out.println(color+" set by "+name);
	}
	public String toString() {
		return "tire ="+this.tire+"Name "+this.name+"door "+this.doors+"Mark hamlek";
	}

	

}
