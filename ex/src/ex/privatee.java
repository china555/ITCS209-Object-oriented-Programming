package ex;

public class privatee 
{
	private String Information;  //attributes

	public privatee(String information)  //constructor
	{
		this.Information = information;
	}
	public String getInformation(String name)  //get use for return sth
	{
		return Information+" get by "+name;
	}

	public void setInformation(String information,String name)  //use to set sth but doesn't return
	{
		Information = information; 
		System.out.println(information+" Change by "+name);
	}
}

