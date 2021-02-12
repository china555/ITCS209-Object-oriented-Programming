

public class car 
{
	public String version;
	public int wheel;
	public int engine;
	public int distance;
	
	public car(String version, int wheel, int engine, int distance) 
	{
		this.version = version;
		this.wheel = wheel;
		this.engine = engine;
		this.distance = distance;
	}
	
	public int getWheel() 
	{ 
		return wheel; 
	}
	public void setWheel(int wheel) 
	{ 
		this.wheel = wheel; 
	}
	
//	public static void main(String[] args)
//	{
//		car toyota = new car("red", 4, 2000, 500);
//		System.out.println(toyota.version+" "+toyota.wheel );
//		toyota.setWheel(10);
//		System.out.println(toyota.version+" "+toyota.wheel);
//	}
}

	
