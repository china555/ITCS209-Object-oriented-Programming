
public abstract class Shape implements Comparable
{
	public static double PI = 3.14;
	public String color;
	public String description;
	
	public Shape(String color, String description) 
	{
		
		this.color = color;
		this.description = description;
	}

	public void setColor(String color)
	{
		this.color = color;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	@Override
	public String toString()
	{
		return this.description +"(color="+this.color+", area="+this.getArea()+")";
	}
	
	public int compareTo(Object shape)
	{
		if(getArea() > ((Shape)shape).getArea())
		{
			return 1;
		}
		else if(getArea() == ((Shape)shape).getArea())
			
		{
			return 0;
		}
		else
			return -1;
		
	}
	
	public abstract double getArea();
}
