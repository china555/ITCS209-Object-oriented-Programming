
public class Student extends Person 
{
	private String stuid;
	private int year;
	
	public Student(String name, int age,String stuid) 
	{
		super(name, age);
		this.stuid = stuid;	
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age, String stuid, int year)
	{
		super(name, age);
		this.stuid = stuid;
		this.year = year;
	}
	
	@Override
	public double getInterest(double rate) 
	{
		// TODO Auto-generated method stub
		return super.getInterest(rate)*1.25;
	}
	
	public double getInterest(double rate,int num)
	{
		return num;
		
	}
	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
