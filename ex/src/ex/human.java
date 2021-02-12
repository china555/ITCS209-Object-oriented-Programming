package ex;

public class human {
	public String body;
	public String brain;
	public String name;
	public int age;
	
public human(String body,String brain,String name,int age) {
	this.body = body;
	this.brain = brain;
	this.name = name;
	this.age = age;
}
public static void main(String[] args) {
	human Tar = new human("fat","smart","Tar",20); 
	System.out.println(Tar.body);
}

}
