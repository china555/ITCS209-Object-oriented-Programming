

public class teacher extends worker //extends from class worker  -have all same attributes
{
	public teacher(String firstname, String lastname, String id,int salary) {
		super(firstname, lastname, id,salary);
		// TODO Auto-generated constructor stub
	}
	private String gender;
	public String getGender(String g) {
		if(g == "m") {
			return "male";
		}
		else if(g == "f") {
			return "female";
		}
		else
		return "none";
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	

}
