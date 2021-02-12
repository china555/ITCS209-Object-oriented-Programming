public class human 
{
	public String first_name;
	public String last_name;
	public int age;
	
	human(String afirst_name,String alast_name,int aage)
	{
		this.first_name = afirst_name;
		this.last_name = alast_name;
		this.age = aage;	
	}
	
	public static void main(String[] args)
	{
		human China = new human("Kittikorn", "Keeratikriangkrai", 19);
		human Nam = new human("Nattawipa", "Saetae", 18);
		human Pear = new human("Pichamol", "Jumnienphet", 16);
		System.out.print(China.first_name+" "+China.last_name+" "+China.age+" ");
		System.out.println(Pear.last_name+" "+Pear.age);
	}
}
