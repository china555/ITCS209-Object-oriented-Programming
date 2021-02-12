public class member 
{
	//try by nongnam on 16/02/2019
	public String firstname;
	public String lastname;
	public String nickname;
	public String university;
	public String id;
	
	member(String afirstname,String alastname,String anickname,String auniversity,String aid)
	{
		this.firstname = afirstname;
		this.lastname = alastname;
		this.nickname = anickname;
		this.university = auniversity;
		this.id = aid;
	}

	public static void main(String[] args)
	{
		member chiba = new member("Chiba", "Kung", "Baba", "dogdog", "0000001");
		System.out.println("Firstname : "+chiba.firstname);
		System.out.println("Lastname : "+chiba.lastname);
		System.out.println("Nickname : "+chiba.nickname);
		System.out.println("University : "+chiba.university);
		System.out.println("ID : "+chiba.id);
	}

}
