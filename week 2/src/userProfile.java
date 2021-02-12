
public class userProfile {
	private int studentID;
	private String name;
	private int age;
	private String address;
	public userProfile(int studentID,String name,int age,String address) {
		this.setStudentID(studentID);
		this.setName(name);
		this.setAge(age);
		this.setAddress(address);
		
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	}
class manageUser{
	public static int ageDiff(int a,int b) {
		if(a>b) {
			return a-b;
		}
		else {
			return b-a;
		}
		
	}
	public static void main(String[] agrs) {
		userProfile student = new userProfile(6188086,"Kittikorn",19,"aaaaa");
		userProfile student2 = new userProfile(6188080,"Sarun",130,"Icondo");
		System.out.println(student.getStudentID()+" "+student.getName()+" "+student.getAge()+"\n"+student.getAddress());
		System.out.println(ageDiff(student.getAge(),student2.getAge()));
	}
}
		