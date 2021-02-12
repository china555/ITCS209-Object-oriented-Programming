
public class Author {
	private String name;
	private char gender;
	private String phoneNum;
	public static int count;
	
	public Author(String name,char gender) {
		this.name = name;
		this.gender = gender;
		this.setPhoneNum("unknow");
		count++;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phone) {
		this.phoneNum = phone;
	}
	public String getname() {
		return name;
	}

}
